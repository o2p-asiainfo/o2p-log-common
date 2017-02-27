/** 
 * Project Name:realTimeLog 
 * File Name:LogUtils.java 
 * Package Name:com.asianinfo.log.utils 
 * Date:2015年9月16日上午11:18:48 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.util;  

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asiainfo.integration.o2p.log.common.datasource.DynamicDataSource;
import com.asiainfo.integration.o2p.log.common.datasource.LogServerConstant;
import com.asiainfo.integration.o2p.log.common.hbase.type.TypeHandler;
import com.asiainfo.integration.o2p.log.common.hbase.type.handler.DefaultTypeHandlers;
import com.asiainfo.foundation.exception.BusinessException;
import com.ailk.eaap.o2p.common.cache.SerializeUtil;
import com.ailk.eaap.op2.bo.EndpointInteraction;
import com.ailk.eaap.op2.bo.JdbcDataSource;
import com.ailk.eaap.op2.bo.LogMessageObject;
import com.ailk.eaap.op2.bo.OriLogClob;
import com.ailk.eaap.op2.common.InType;
import com.linkage.rainbow.util.expr.core.Expr;

public final class LogUtils {
    
    private static final Logger LOG = LoggerFactory.getLogger(LogUtils.class);
    public static final String PROPERTY_NAME_SPACE = "PROPERTY_NAME_SPACE";
    public static final String CONNECT_STRING = "CONNECT_STRING";
    private transient static Map<String, Object> daoMap = new HashMap<String, Object>();
    private transient static Map<String, JdbcDataSource> jdbcDataSourceMap = new HashMap<String, JdbcDataSource>();
    
    
    public static final Map<String,String> DATE_TYPE_VALUE_MAP = new HashMap<String,String>(){
        {
            put("3","yyyyMMdd");
            put("2","yyyyMMddHH");
            put("1","yyyyMMddHHmm");
            put("0","yyyyMMddHHmmss");
        }
   };
    /**
     * 获取分表后缀
     * @author daimq 
     * @param Timestamp 当前时间戳
     * @return 
     * @since JDK 1.6
     */
    public static String getTableSuffix(Timestamp curr, String suffixFormat){
        String suffix = "";
        SimpleDateFormat sdf = new SimpleDateFormat(suffixFormat.substring(1));
        suffix = sdf.format(curr);
        return "_"+suffix;
    }
    public static String getTableSuffix(Timestamp curr){
        String suffix = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        suffix = sdf.format(curr);
        return "_"+suffix;
    }
    
    public static String getUUID(){
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }
    
    public static Timestamp ifAndGetUTCTimestamp(Timestamp timestamp,String ifConvert){
        if("TRUE".equals(ifConvert.toUpperCase())){
            return getUTCTimestamp(timestamp);
        }else{
            return timestamp;
        }
    }
    
    public static  Timestamp getUTCTimestamp(Date dateTime) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        int timeOffset=-(zoneOffset + dstOffset)/(60*1000);
        return new Timestamp(getUTCByLocalDate(dateTime, timeOffset).getTime());
    }
    
    public static Date getUTCByLocalDate(Date localDate,int timeOffset){
        Calendar cal=Calendar.getInstance();
        cal.setTime(localDate);
        cal.add(Calendar.MINUTE, timeOffset);
        return cal.getTime();
    }
    
    
    
    public static String getStatisticsDateTypeValue(Date value,String dateType){
        String pattern = DATE_TYPE_VALUE_MAP.get(dateType);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern); 
        return formatter.format(value);  
    }
    
    
    public static <T> List<T> mapToList(Map<String,T> map){
        List<T> list = new ArrayList<T>();
        Set<Map.Entry<String,T>> entrys = map.entrySet();
        for(Map.Entry<String,T> entry : entrys){
            list.add(entry.getValue());
        }
        return list;
    }
    
    
    public static String getRowKeyByUUID(){
        String uuid = UUID.randomUUID().toString();  
        return Md5Util.encryption(uuid);
    }
    
 
    
    public static byte[] getByteKey(Field field)  {

        TypeHandler typeHandler = DefaultTypeHandlers
                .findDefaultHandler((Class<?>) field.getName().getClass());
        return typeHandler.toBytes((Class<?>) field.getName().getClass(),
                field.getName());

    }

    public static byte[] getByteValue(Field field,Object value){

        TypeHandler typeHandler = DefaultTypeHandlers
                .findDefaultHandler((Class<?>) field.getType());
        if(typeHandler == null){
            throw new BusinessException(9999, field.getType()+" no matching typeHandler");
        }
        return typeHandler.toBytes((Class<?>) field.getType(), value);
    }
    
    public static List<EndpointInteraction> mergeLogEIAndOri(List<EndpointInteraction> eis,List<OriLogClob> oris,Timestamp timestamp){
        if(CollectionUtils.isEmpty(eis) && CollectionUtils.isEmpty(oris)){
            return eis;
        }
        Map<String,String> clobMap = new HashMap<String,String>();
        for(int i = 0;i<oris.size();i++){
            OriLogClob ori = oris.get(i);
            if(ori != null){
                String key = ori.getEndPointId()+ori.getReqOrRes();
                clobMap.put(key,ori.getMsg());
                //clobMap.put(key,Compressor.gzip(ori.getMsg()));
            }
        }
        
        for(int i=0;i<eis.size();i++){
            EndpointInteraction endpointInteraction=(EndpointInteraction)eis.get(i);
            String endpointInteractionId = LogUtils.getUUID();
            endpointInteraction.setEndpointInteractionId(endpointInteractionId);
            endpointInteraction.setCreateDate(LogUtils.ifAndGetUTCTimestamp(timestamp,Properties.getInstance().getIfFormatUTC()));
            endpointInteraction.setInMsg(clobMap.get(endpointInteraction.getEndpointId()+"0"));
            endpointInteraction.setOutMsg(clobMap.get(endpointInteraction.getEndpointId()+"1"));
        }
        
        return eis;
        
    }

    public static void setZkAddrEntrance(Map map){
        if(System.getProperty(PROPERTY_NAME_SPACE) == null && map.get(PROPERTY_NAME_SPACE) != null){
            System.setProperty(PROPERTY_NAME_SPACE,(String) map.get(PROPERTY_NAME_SPACE));
        }
        if(System.getProperty(CONNECT_STRING) == null && map.get(CONNECT_STRING) != null){
            System.setProperty(CONNECT_STRING,(String) map.get(CONNECT_STRING));
        }
    }
    
    public static void setMultiDatasource(List<LogMessageObject> logMessageObjects, Map<String, Object> dataSourceMap, Map<String, List<LogMessageObject>> logsMap, Timestamp currTimestamp){
    	for(LogMessageObject logMessageObject : logMessageObjects){
	    	Map<String, String> routeMap = logMessageObject.getJavaFiledMap();
	    	Map<String,Object> msgRouteMap = new ConcurrentHashMap<String,Object>();//消息过来的路由条件最终形式
			if(routeMap != null ){
				Set<String> set = routeMap.keySet();
				Iterator<String> iterator = set.iterator();
				String[] exclustionKeyArray = new  String[]{InType.Format,InType.AccessToken,InType.ReqTime,InType.TRANSID,InType.Sign, InType.tenantId};
				List<String> exclusionkeyList = Arrays.asList(exclustionKeyArray);
				while (iterator.hasNext()) {
					String key = iterator.next();
					String finalKey = LogServerConstant.KEY_MAP.get(key);
					String value = (String) routeMap.get(key);
					if(value != null && !exclusionkeyList.contains(key))
						msgRouteMap.put(finalKey, value);
				}
			}
		
			boolean isRouted = false;
			//get from cache
			List dataSourceRouteList = (List) dataSourceMap.get("dataSourceRouteList");
			Iterator it = dataSourceRouteList.iterator();
			String dataSourceName = "";
			while(it.hasNext()){
				Map map = (Map)it.next();
				Integer t1 = Integer.valueOf(logMessageObject.getJavaFiledMap().get(InType.tenantId));
				Integer t2 = Integer.valueOf(map.get("TENANT_ID").toString());
				if(t1!=t2){
					continue;
				}
				Expr expr = (Expr)map.get("EXPR");
				Object result = expr.calculate(msgRouteMap);
				if(result != null && result.toString().equals("true")){
					//DataSourceRouteUtil.putContextDataSourceName((String)map.get("DATA_SOURCE_NAME"));
					dataSourceName = (String)map.get("DATA_SOURCE_NAME");
					logMessageObject.setDataBaseTableSuffix(getTableSuffix(currTimestamp, map.get("TAB_SUFFIX")==null?"_YYMM" : map.get("TAB_SUFFIX").toString()));
					logsMap.get(logMessageObject.getJavaFiledMap().get(InType.tenantId) + map.get("DATA_SOURCE_ID")).add(logMessageObject);
					isRouted = true;
					break;
				}else {
					if(map.get("IS_DEFAULT")!=null && map.get("IS_DEFAULT").toString().equals("0")){
						dataSourceName = (String)map.get("DATA_SOURCE_NAME");
						logMessageObject.setDataBaseTableSuffix(getTableSuffix(currTimestamp, map.get("TAB_SUFFIX")==null?"_YYMM" : map.get("TAB_SUFFIX").toString()));
						logsMap.get(logMessageObject.getJavaFiledMap().get(InType.tenantId) + map.get("DATA_SOURCE_ID")).add(logMessageObject);
					}
				}
			}
			logMessageObject.setDataSourcekey(dataSourceName);
    	}
    }
    
    public static Object getDaoObject(String beanId, JdbcDataSource jds){
		String dsKey = jds.getTenantId().toString() + String.valueOf(jds.getDataSourceId());
		DynamicDataSource dds = (DynamicDataSource) SpringContext.getBeansContext().getBean("multiDataSource");
		if(!jdbcDataSourceMap.containsKey(dsKey) || (!jds.equals(jdbcDataSourceMap.get(dsKey)))){//create new connection and cached
			LOG.info("----create new connection, dsKey=" + dsKey);
			//close connection if necessary
			if(jdbcDataSourceMap.containsKey(dsKey)){
				try {
					LOG.info("----close old connection, dsKey=" + dsKey);
					dds.getDataSource().getConnection().close();
				} catch (Exception e) {
					LOG.error("close db connection error!", e);
				}
			}
    		dds.setDataSource(jds);
    		Object daoObject = SpringContext.getBeansContext().getBean(beanId);
    		//cached
    		daoMap.put(dsKey, daoObject);
    		jdbcDataSourceMap.put(dsKey, jds);
    		return daoObject;
		}else{
			if(!jds.equals(dds.getDataSource())){//switch datasource
				LOG.info("----switch datasource, target dsKey=" + dsKey);
				try {
					dds.getDataSource().getConnection().close();
				} catch (Exception e) {
					LOG.error("close db connection error!", e);
				}
				dds.setDataSource(jds);
			}
			LOG.info("----get dao from cached object, dsKey=" + dsKey);
			return daoMap.get(dsKey);
		}
    }
    
    private LogUtils(){
    }
}
