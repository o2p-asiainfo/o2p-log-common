/** 
 * Project Name:o2p-log-common 
 * File Name:ComplexProOF.java 
 * Package Name:com.asiainfo.log.common.hbase.fields 
 * Date:2015年11月23日下午11:26:26 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.hbase.fields;  
/** 
 * ClassName:ComplexProOF  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年11月23日 下午11:26:26  
 * @author   daimq 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public final class EmbeddedExpAndCtgLogKeys {

    
    //EXPCEPITON_LOGS
    public final static String EXP_MSG = "exceptionMessage";
    public final static String EXP_CONTENT = "exceptionContent";
    
    
    //CTGLOGS
    public final static String CTG_ERR_CODE = "ctgErrcode";
    public final static String CTG_FUN_NAME = "ctgFunName";
    public final static String CTG_ERR_MSG = "ctgErrMsg";
    public final static String CTG_DESC = "ctgDesc";
    public final static String CTG_STATUS = "ctgStatus";
    public final static String CTG_TENANT_ID = "tenantId";
    
    private EmbeddedExpAndCtgLogKeys(){
    }
    
    
}
