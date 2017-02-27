/** 
 * Project Name:o2p-common 
 * File Name:HbaseConfig.java 
 * Package Name:com.ailk.eaap.o2p.common.solr 
 * Date:2015年11月20日下午3:55:03 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.solr;  
/** 
 * ClassName:HbaseConfig  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年11月20日 下午3:55:03  
 * @author   daimq 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class HbaseConfig {
    public final static String TAB_CI = "EVENT_CI";
    public final static String TAB_EI = "EVENT_EI";
    public final static String FAMILY_CI = "mainInfo";
    public final static String FAMILY_EI = "msgDetail";
    public final static String QUALIFIER_EXCEPTION = "exceptionLogs";
    public final static String QUALIFIER_CTG = "ctgErrInfo";
    public final static String QUALIFIER_EIORILOG = "eiOriLogs";
    public final static String QUALIFIER_ROWKEY = "contractInteractionId";
    public final static String QUELIFIER_CREATETIME = "createTime";
    public final static String QUELIFIER_SRCSYSSIGN = "srcSysSign";
}
