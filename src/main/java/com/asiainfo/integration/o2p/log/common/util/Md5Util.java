/** 
 * Project Name:realTimeLog 
 * File Name:Md5Util.java 
 * Package Name:com.asianinfo.log.utils 
 * Date:2015年10月5日下午3:20:15 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.util;  

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * ClassName:Md5Util  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年10月5日 下午3:20:15  
 * @author   daimq 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public final class Md5Util {

    private static final Logger LOG = LoggerFactory.getLogger(Md5Util.class);
    private static final String ARITHMETIC_NAME = "MD5";
    public static String encryption(String plainText) {

        String reMd5 = null;

        try {

            MessageDigest md = MessageDigest.getInstance(ARITHMETIC_NAME);

            md.update(plainText.getBytes());

            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");

            for (int offset = 0; offset < b.length; offset++) {

                i = b[offset];

                if (i < 0){
                    i += 256;
                }
                if (i < 16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            reMd5 = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            LOG.error("MD5 encode Exception", e);
        }
        return reMd5;
    }
    
    private  Md5Util(){
    }

}
