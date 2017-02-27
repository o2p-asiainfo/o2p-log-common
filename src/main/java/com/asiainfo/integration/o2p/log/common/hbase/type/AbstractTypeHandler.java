/** 
 * Project Name:realTimeLog 
 * File Name:AbstractTypeHandler.java 
 * Package Name:com.asianinfo.log.hbase.type 
 * Date:2015年10月5日下午3:48:50 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.hbase.type;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * ClassName:AbstractTypeHandler  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年10月5日 下午3:48:50  
 * @author   daimq 
 * @version   
 * @since    JDK 1.6 
 *        
 */
abstract public class AbstractTypeHandler implements TypeHandler {

    private final static Logger LOG = LoggerFactory.getLogger(AbstractTypeHandler.class);
    /**
     * Should this handler handle specified java type?
     * */
    abstract protected boolean aboutToHandle(Class<?> type);

    abstract protected byte[] innerToBytes(Class<?> type, Object value);

    abstract protected Object innerToObject(Class<?> type, byte[] bytes);

    public byte[] toBytes(Class<?> type,  Object value) {
      //  Util.checkNull(type);

        if (!aboutToHandle(type)) {
            try {
                throw new Exception("wrong type to handle. type = "
                        + type);
            } catch (Exception e) {
                LOG.error("class type:"+type+",value:"+value+"toBytes err,cause by:",e);
            }
        }

        if (value == null) {
            return null;
        }

        return innerToBytes(type, value);
    }

    @Override
    public Object toObject(Class<?> type,  byte[] bytes) {
       // Util.checkNull(type);

        if (!aboutToHandle(type)) {
            try {
                throw new Exception("wrong type to handle. type = "
                        + type);
            } catch (Exception e) {
                LOG.error("class type:"+type+",bytes:"+bytes+"toObject err,cause by:",e);
            }
        }

        if (bytes == null || bytes.length == 0) {
            return null;
        }

        return innerToObject(type, bytes);
    }

}

