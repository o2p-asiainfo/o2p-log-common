/** 
 * Project Name:realTimeLog 
 * File Name:DefaultTypeHandlers.java 
 * Package Name:com.asianinfo.log.hbase.type 
 * Date:2015年10月5日下午3:37:49 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.hbase.type.handler;  

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.integration.o2p.log.common.hbase.type.TypeHandler;
import com.asiainfo.integration.o2p.log.common.hbase.util.ClassUtil;






/** 
 * ClassName:DefaultTypeHandlers  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年10月5日 下午3:37:49  
 * @author   daimq 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class DefaultTypeHandlers {
        // private static EnumHandler                enumHandler     = new EnumHandler();
           private static Map<Class<?>, TypeHandler> defaultHandlers = new HashMap<Class<?>, TypeHandler>();

         static {
             defaultHandlers.put(String.class,       new StringHandler());
             defaultHandlers.put(Date.class,         new DateHandler());
             defaultHandlers.put(Boolean.class,      new BooleanHandler());
             defaultHandlers.put(Character.class,    new CharacterHandler());
             defaultHandlers.put(Byte.class,         new ByteHandler());
             defaultHandlers.put(Short.class,        new ShortHandler());
             defaultHandlers.put(Integer.class,      new IntegerHandler());
             defaultHandlers.put(Long.class,         new LongHandler());
             defaultHandlers.put(Float.class,        new FloatHandler());
             defaultHandlers.put(Double.class,       new DoubleHandler());
             defaultHandlers.put(Timestamp.class,        new SqlTimestampHandler());
         }

         public static TypeHandler findDefaultHandler(Class<?> type) {
             //Util.checkNull(type);
             type = ClassUtil.tryConvertToBoxClass(type);

//             if (type.isEnum()) {
//                 return enumHandler;
//             }

             return defaultHandlers.get(type);
         }

}
