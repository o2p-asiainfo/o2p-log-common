package com.asiainfo.integration.o2p.log.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.common.cache.ICache;
import com.ailk.eaap.o2p.common.security.SecurityUtil;
import com.ailk.eaap.op2.bo.JdbcDataSource;
import com.ailk.eaap.op2.bo.Tenant;

public class CacheUtils {
	private static final Logger LOG = LoggerFactory.getLogger(CacheUtils.class);
	public static final String ALL_DATASOURCE_LIST = "ALL_DATASOURCE_LIST";
	public static final String ALL_DATASOURCE_MAP = "ALL_DATASOURCE_MAP";
	private static Map<Integer, List<JdbcDataSource>> datasourcelistMap = new HashMap<Integer, List<JdbcDataSource>>();
	private static Map<String, Object> map = new HashMap<String, Object>();
	private static Map<String, Object> lastVersionMap = new HashMap<String, Object>();
	private static Object lastVersion;
	
	static{
		map.put(ALL_DATASOURCE_LIST, new ArrayList<JdbcDataSource>());
		map.put(ALL_DATASOURCE_MAP, new HashMap<String, Object>());
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getAllDataSource(ICache<String, Object> cacheClient){
		try{
	    	List<Tenant> list = (List<Tenant>) cacheClient.get(CacheKey.TENANT_ALL);
	    	if(list==null || list.isEmpty()){
	    		LOG.warn("There is no tenant info in cache!");
	    		return null;
	    	}
			List<JdbcDataSource> allDataSourceList = new ArrayList<JdbcDataSource>();
	    	for(Tenant tenant : list){
	    		List<JdbcDataSource> dataSourceList = (List<JdbcDataSource>) cacheClient.get(tenant.getTenantId() + CacheKey.ALL_DATA_SOURCE);
	    		if(dataSourceList!=null && !dataSourceList.isEmpty()){
	    			allDataSourceList.addAll(dataSourceList);
	    		}
	    		Object nowVersion = cacheClient.get(tenant.getTenantId() + CacheKey.MODULE_DATA_SOURCE);
	    		if(nowVersion!=null && lastVersionMap.get(tenant.getTenantId())!=null && nowVersion.equals(lastVersionMap.get(tenant.getTenantId()))){
	    			continue;
	    		}
	    		
	        	Map<String, Object> datasourceMap = (Map<String, Object>) cacheClient.get(tenant.getTenantId() + CacheKey.DATA_SOURCE_MAP);
	        	//set all datasourcemap
	        	if(datasourceMap!=null){
	        		List<Map<String,Object>> tempDataSourceRouteList = (List<Map<String,Object>>)datasourceMap.get("dataSourceRouteList");
	        		List<Map<String,Object>> tempDataSourceList = (List<Map<String,Object>>)datasourceMap.get("dataSourceList");
	        		Map<String, Object> tempDataSourceMap = (Map<String, Object>)datasourceMap.get("dataSourceMap");
	        		((Map<String, Object>)map.get(ALL_DATASOURCE_MAP)).putAll(tempDataSourceMap);
	        		((Map<String, Object>)map.get(ALL_DATASOURCE_MAP)).put("dataSourceRouteList", unionList((List<Map<String,Object>>)((Map<String, Object>)map.get(ALL_DATASOURCE_MAP)).get("dataSourceRouteList"), tempDataSourceRouteList));
	        		((Map<String, Object>)map.get(ALL_DATASOURCE_MAP)).put("dataSourceList", unionList((List<Map<String,Object>>)((Map<String, Object>)map.get(ALL_DATASOURCE_MAP)).get("dataSourceList"), tempDataSourceList));
	        	}
	    	}
	    	map.put(ALL_DATASOURCE_LIST, allDataSourceList);
		}catch(Exception e){
			LOG.error("get datasource info from remote cache error, it will return cached info in local cache", e);
		}
	    return map;
	}
	
	public static List<Map<String,Object>> unionList(List<Map<String,Object>> list, List<Map<String,Object>> subList){
		if(subList==null || subList.isEmpty()){
			return list;
		}
		if(list==null){
			list = new ArrayList<Map<String,Object>>();
		}
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>();
		for(Map<String,Object> map : list){
			result.put(map.get("TENANT_ID").toString() + map.get("DATA_SOURCE_ID").toString(), map);
		}
		for(Map<String,Object> map : subList){
			result.put(map.get("TENANT_ID").toString() + map.get("DATA_SOURCE_ID").toString(), map);
		}
		list.clear();
		for(Map.Entry<String, Map<String,Object>> kv : result.entrySet()){
			list.add(kv.getValue());
		}
		return list;
	}
	
	public static String getTabSuffix(Integer tenantId, Integer datasourceId, ICache<String, Object> cacheClient){
		Map<String,Object> datasourceMap = (Map<String,Object>) cacheClient.get(tenantId + CacheKey.DATA_SOURCE_MAP);
		List<Map<String,Object>> dataSourceRouteList = (List<Map<String,Object>>) datasourceMap.get("dataSourceRouteList");
		for(Map<String,Object> map : dataSourceRouteList){
			if(map.get("DATA_SOURCE_ID").equals(datasourceId)){
				return map.get("TAB_SUFFIX").toString();
			}
		}
		return "_YYMM";
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<JdbcDataSource> getDataSourceListByTenantId(Integer tenantId, ICache<String, Object> cacheClient){
		if(tenantId==null){
			LOG.warn("tenantId is null!");
			return null;
		}
		Object nowVersion = cacheClient.get(tenantId + CacheKey.MODULE_DATA_SOURCE);
		if(nowVersion==null){
			LOG.warn("There is some error in level-1 cache? return the last data get from cache");
			return datasourcelistMap.get(tenantId);
		}
		if(lastVersion==null){//first time get data from cache
			lastVersion = nowVersion;
			List<JdbcDataSource> datasourceList = (List<JdbcDataSource>) cacheClient.get(tenantId + CacheKey.ALL_DATA_SOURCE);
			if(datasourceList!=null && !datasourceList.isEmpty()){
				for(JdbcDataSource jds : datasourceList){
					String password = SecurityUtil.getInstance().decryMsg(jds.getPassword());
		    		jds.setPassword(password==null?jds.getPassword():password);
				}
			}
			datasourcelistMap.put(tenantId, datasourceList);
			return datasourceList;
		}else{
			if(nowVersion.equals(lastVersion)){//no change for the datasource info of this tenant in cache
				return datasourcelistMap.get(tenantId);
			}else{//this tenant's datasource info had been updated
				lastVersion = nowVersion;
				List<JdbcDataSource> datasourceList = (List<JdbcDataSource>) cacheClient.get(tenantId + CacheKey.ALL_DATA_SOURCE);
				if(datasourceList!=null && !datasourceList.isEmpty()){
					for(JdbcDataSource jds : datasourceList){
						String password = SecurityUtil.getInstance().decryMsg(jds.getPassword());
			    		jds.setPassword(password==null?jds.getPassword():password);
					}
				}
				datasourcelistMap.put(tenantId, datasourceList);
				return datasourceList;
			}
		}
	}
}
