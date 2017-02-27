/** 
 * Project Name:realTimeLog 
 * File Name:TypeHandler.java 
 * Package Name:com.asianinfo.log.hbase.type 
 * Date:2015年10月5日下午3:36:08 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.hbase.type;  
/** 
 * ClassName:TypeHandler  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年10月5日 下午3:36:08  
 * @author   daimq 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public interface TypeHandler {
        /**
         * Convert java object to hbase's column bytes.
         * 
         * @param type java's type.
         * @param value java's object.
         * @return hbase's column bytes.
         * */
        public byte[] toBytes(Class<?> type,  Object value);

        /**
         * Convert hbase's column bytes to java object.
         * 
         * @param type java object's type.
         * @param bytes hbase's column bytes.
         * @return java object.
         * */
        public Object toObject(Class<?> type,  byte[] bytes);
}
