//package com.asiainfo.integration.o2p.log.common.datasource;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.sql.DataSource;
//
//import com.ailk.eaap.o2p.common.cache.CacheKey;
//import com.ailk.eaap.o2p.common.cache.ICacheFactory;
//import com.ailk.eaap.o2p.common.jdbc.datasource.DataSourceRouteUtil;
//import com.ailk.eaap.op2.bo.JdbcDataSource;
//import com.ailk.eaap.op2.common.InType;
//import com.asiainfo.foundation.log.LogModel;
//import com.asiainfo.foundation.log.Logger;
//import com.asiainfo.integration.o2p.log.common.bo.DataSourceObject;
//import com.asiainfo.integration.o2p.log.common.util.SpringUtil;
//import com.linkage.rainbow.dao.IMultiDataSourceRoute;
//import com.linkage.rainbow.dao.MultiDataSource;
//import com.linkage.rainbow.util.context.ContextUtil;
//import com.linkage.rainbow.util.expr.core.Expr;
//
///**
// * 根据线程变量多数据源动态路由规则实现类
// * @author  陈亮
// *
// */
//public class MultiDataSourceRouteImpl implements IMultiDataSourceRoute{
//	
//	private final static Logger logger =Logger.getLog(MultiDataSourceRouteImpl.class);
//	
//	//取得BusCode，正则表达式
//	private final static Pattern busCodePattern = Pattern.compile("<TcpCont>.*?<BusCode>(.*?)</BusCode>.*?</TcpCont>",Pattern.DOTALL);
//	//取得ServiceCode，正则表达式
//	private final static Pattern svcCodePattern = Pattern.compile("<TcpCont>.*?<ServiceCode>(.*?)</ServiceCode>.*?</TcpCont>",Pattern.DOTALL);
//	//取得SrcOrgID，正则表达式
//	private final static Pattern orgIdPattern = Pattern.compile("<TcpCont>.*?<SrcOrgID>(.*?)</SrcOrgID>.*?</TcpCont>",Pattern.DOTALL);
//	
//	/**
//	 * 数据源路由操作
//	 * 支持buscode,svccode,regionID 三个维度的判断
//	 * @param originalMessage 接收到的报文
//	 */
//	public void setRoutingRules(String originalMessage) {
//		
//		String orgId = null;
//		String busCode = null;
//		String svcCode = null;
//		//从报文头中获取orgId,busCode,svcCode
//		try {
//			Matcher matcher = busCodePattern.matcher(originalMessage);
//			if (matcher.find()) {
//				busCode = matcher.group(1).trim();
//			}
//			matcher = svcCodePattern.matcher(originalMessage);
//			if (matcher.find()) {
//				svcCode = matcher.group(1).trim();
//			}			
//			matcher = orgIdPattern.matcher(originalMessage);
//			if (matcher.find()) {
//				orgId = matcher.group(1).trim();
//			}
//		} catch (Throwable e) {
//			logger.error(LogModel.EVENT_APP_EXCPT, e);
//		}
//		
//		//根据报文头进行数据源路由
////		boolean isRouted = false;
//		if(orgId != null && busCode != null && svcCode!= null){
//			List dataSourceRouteList = DataSourceRouteUtil.getDataSourceRouteList();
//			Iterator it = dataSourceRouteList.iterator();
//			Map para = new ConcurrentHashMap<String, Object>();
//			para.put("ORG_ID", orgId);
//			para.put("BUS_CODE", busCode);
//			para.put("SVC_CODE", svcCode);
//			while(it.hasNext()){
//				Map map = (Map)it.next();
//				Expr expr = (Expr)map.get("EXPR");
//				Object result = expr.calculate(para);
//				if(result != null && result.toString().equals("true")){
//					DataSourceRouteUtil.putContextDataSourceName((String)map.get("DATA_SOURCE_NAME"));
////					isRouted = true;
//					break;
//				}
//			} 
//		}
//		//如果报文头信息不完整无法正常路由，则默认路由的第个数据源
////		if(!isRouted){
////			List dsList = (List)DataSourceRouteCache.getDataSourceRouteMap().get("dataSourceList");
////			String dsName = (String)((Map)dsList.get(0)).get("DATA_SOURCE_NAME");
////			String tabSuffix = (String)((Map)dsList.get(0)).get("TAB_SUFFIX");
////			ContextUtil.put(RainbowDomain.DepDataSourceContextName,dsName); //数据源名称
////			ContextUtil.put(RainbowDomain.DepTabSuffixContextName,tabSuffix);//物理表名后缀			
////		}
//
//	}
//	
////	public void setRoutingRules_old(Map routeMap){
////		String orgId = null;
////		String busCode = null;
////		String svcCode = null;
////
////		if(routeMap.get("orgId")!=null)
////			orgId =(String) routeMap.get("orgId");
////		else
////			orgId="";
////		if(routeMap.get("busCode")!=null)
////			busCode =(String) routeMap.get("busCode");
////		else 
////			busCode="";
////		if(routeMap.get("svcCode")!=null)
////			svcCode =(String) routeMap.get("svcCode");	
////		else
////			svcCode="";
////		boolean isRouted = false;
////		if(orgId != null && busCode != null && svcCode!= null){
////			List dataSourceRouteList = DataSourceRouteUtil.getDataSourceRouteList();
////			Iterator it = dataSourceRouteList.iterator();
////			Map para = new ConcurrentHashMap<String, Object>();
////			para.put("ORG_ID", orgId);
////			para.put("BUS_CODE", busCode);
////			para.put("SVC_CODE", svcCode);
////			String dataSourceName="";
////			while(it.hasNext()){
////				Map map = (Map)it.next();
////				Expr expr = (Expr)map.get("EXPR");
////				Object result = expr.calculate(para);
////				if(result != null && result.toString().equals("true")){
////					//DataSourceRouteUtil.putContextDataSourceName((String)map.get("DATA_SOURCE_NAME"));
////					dataSourceName = (String)map.get("DATA_SOURCE_NAME");
////					isRouted = true;
////					break;
////				}else {
////					if(map.get("IS_DEFAULT")!=null && map.get("IS_DEFAULT").toString().equals("0")){
////						dataSourceName = (String)map.get("DATA_SOURCE_NAME");
////					}
////				}
////			}
////			DataSourceRouteUtil.putContextDataSourceName(dataSourceName);
////		}
////	}
//	
//	
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public void setRoutingRules(Map routeMap){
//		Map<String,Object> msgRouteMap = new ConcurrentHashMap<String,Object>();//消息过来的路由条件最终形式
//		if(routeMap != null ){
//			Set<String> set = routeMap.keySet();
//			Iterator<String> iterator = set.iterator();
//			String[] exclustionKeyArray = new  String[]{InType.Format,InType.AccessToken,InType.ReqTime, InType.TRANSID,InType.Sign};
//			List<String> exclusionkeyList = Arrays.asList(exclustionKeyArray);
//			while (iterator.hasNext()) {
//				String key = iterator.next();
//				String finalKey = LogServerConstant.KEY_MAP.get(key);
//				String value = (String) routeMap.get(key);
//				if(value != null && !exclusionkeyList.contains(key))
//					msgRouteMap.put(finalKey, value);
//			}
//		}
//	
//		boolean isRouted = false;
//		List dataSourceRouteList = DataSourceRouteUtil.getDataSourceRouteList();
//		Iterator it = dataSourceRouteList.iterator();
//		String dataSourceName="";
//		while(it.hasNext()){
//			Map map = (Map)it.next();
//			Expr expr = (Expr)map.get("EXPR");
//			Object result = expr.calculate(msgRouteMap);
//			if(result != null && result.toString().equals("true")){
//				//DataSourceRouteUtil.putContextDataSourceName((String)map.get("DATA_SOURCE_NAME"));
//				dataSourceName = (String)map.get("DATA_SOURCE_NAME");
//				isRouted = true;
//				break;
//			}else {
//				if(map.get("IS_DEFAULT")!=null && map.get("IS_DEFAULT").toString().equals("0")){
//					dataSourceName = (String)map.get("DATA_SOURCE_NAME");
//				}
//			}
//		}
//		DataSourceRouteUtil.putContextDataSourceName(dataSourceName);
//	}
//	
//
//	/**
//	 * 获取当前线程的路由Key
//	 * 
//	 * @return
//	 */
//	public String getDataSourceKey() {
//		MultiDataSource multiDataSource = (MultiDataSource) SpringUtil.context.getBean("dataSource");
//		ICacheFactory<String, Object> cacheFactory = (ICacheFactory<String, Object>) SpringUtil.context.getBean("cacheFactory");
//		Map<String, DataSource> datasourceMap = new HashMap<String, DataSource>();
//		List<JdbcDataSource> dataSourceList = (List<JdbcDataSource>) cacheFactory.getCacheClient().get("1"+CacheKey.ALL_DATA_SOURCE);
//		Map<String, DataSource> dataSourceMap = new HashMap<String,DataSource>();
//		String key="";
//		if(dataSourceList != null && dataSourceList.size()>0){
//			for(int i=0; i<dataSourceList.size(); i++) {
//				JdbcDataSource dataSourceObject= dataSourceList.get(i);
//				if(!"Y".equals(dataSourceObject.getIsBeginInit())) continue;
//				  key = dataSourceObject.getDataSourceName();
//				  dataSourceMap.put(key, dataSourceObject);
//			}
//		}
//		
//		multiDataSource.setDatasourceMap(datasourceMap);
//		return "o2p_log2";
////		return (String) ContextUtil.get(LogServerConstant.DepDataSourceContextName);
//	}
//
//}