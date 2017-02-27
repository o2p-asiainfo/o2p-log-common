/** 
 * Project Name:realTimeLog 
 * File Name:Compressor.java 
 * Package Name:com.asianinfo.log.utils 
 * Date:2015年9月16日下午11:00:23 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.util;  

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/** 
 * ClassName:Compressor  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年9月16日 下午11:00:23  
 * @author   daimq 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class Compressor {
    private static final Logger LOG = LoggerFactory.getLogger(Compressor.class);
    /**
     * 使用zip压缩
     * @author daimq 
     * @param paramString
     * @return byte[]
     * @since JDK 1.6
     */
     public static final String zip(String paramString) { 
            if (StringUtils.isEmpty(paramString)) {
                return null; 
            }
            ByteArrayOutputStream byteArrayOutputStream = null; 
            ZipOutputStream zipOutputStream = null; 
            byte[] arrayOfByte; 
            try { 
                byteArrayOutputStream = new ByteArrayOutputStream(); 
                zipOutputStream = new ZipOutputStream(byteArrayOutputStream); 
                zipOutputStream.putNextEntry(new ZipEntry("0")); 
                zipOutputStream.write(paramString.getBytes("UTF-8")); 
                zipOutputStream.closeEntry(); 
                arrayOfByte = byteArrayOutputStream.toByteArray(); 
                return new String(new Base64().encode(arrayOfByte));
            } catch (IOException e) { 
                LOG.error("zip exe err,cause by:",e);
                return null;
            } finally { 
                if (zipOutputStream != null){ 
                    try { 
                        zipOutputStream.close(); 
                    } catch (IOException e) {
                        LOG.error("zip exe err when zipOutputStream closed ,cause by:",e);
                    } 
                }    
                if (byteArrayOutputStream != null) {
                    try { 
                        byteArrayOutputStream.close(); 
                    } catch (IOException e) { 
                        LOG.error("zip exe err when byteArrayOutputStream closed ,cause by:",e);
                    } 
                }     
            } 
        } 
        /**
         * 解压zip压缩的内容
         * @author daimq 
         * @param paramArrayOfByte
         * @return String
         * @since JDK 1.6
         */
        public static final String unZip(String compressString) { 
            if (StringUtils.isEmpty(compressString)) {
                return null; 
            }
            ByteArrayOutputStream byteArrayOutputStream = null; 
            ByteArrayInputStream byteArrayInputStream = null; 
            ZipInputStream zipInputStream = null; 
            try { 
                byteArrayOutputStream = new ByteArrayOutputStream(); 
                byte[] bytes = new  Base64().decode(compressString);
                byteArrayInputStream = new ByteArrayInputStream(bytes); 
                zipInputStream = new ZipInputStream(byteArrayInputStream); 
                ZipEntry localZipEntry = zipInputStream.getNextEntry(); 
                if(LOG.isDebugEnabled()){
                    //output :0
                    LOG.debug("zip entry key："+localZipEntry.getName());
                }
                byte[] arrayOfByte = new byte[1024]; 
                int i = -1; 
                while ((i = zipInputStream.read(arrayOfByte)) != -1){
                    byteArrayOutputStream.write(arrayOfByte, 0, i); 
                }
                return byteArrayOutputStream.toString("UTF-8"); 
            } catch (IOException e) { 
                LOG.error("unZip exe err,cause by:",e);
                return null;
            } finally { 
                if (zipInputStream != null){ 
                    try { 
                        zipInputStream.close(); 
                    } catch (IOException e) { 
                        LOG.error("unZip err when close zipInputStream,cause by:", e);
                    }
                }    
                if (byteArrayInputStream != null){ 
                    try { 
                        byteArrayInputStream.close(); 
                    } catch (IOException e) { 
                        LOG.error("unZip err when close byteArrayInputStream,cause by:", e);
                    } 
                }   
                if (byteArrayOutputStream != null){ 
                    try { 
                        byteArrayOutputStream.close(); 
                    } catch (IOException e) {
                        LOG.error("unZip err when close byteArrayOutputStream,cause by:", e);
                    } 
                }     
            } 
        }
        
        /**
         * 使用gzip进行压缩
         * @author daimq 
         * @param paramString
         * @return 
         * @since JDK 1.6
         */
        public static String gzip(String paramString){
            if (StringUtils.isEmpty(paramString)) {
                return null;
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            GZIPOutputStream gzip=null;
            try {
                gzip = new GZIPOutputStream(out);
                gzip.write(paramString.getBytes("UTF-8"));
            } catch (IOException e) {
                LOG.error("gzip err cause by:", e);
            }finally{
                if(gzip!=null){
                   try {
                       gzip.close();
                   } catch (IOException e) {
                       LOG.error("gzip err when close gzip,cause by:", e);
                   }
                }
            }
            return new String(new Base64().encode(out.toByteArray()));
        }
        
        /**
         * 解压使用gzip压缩的内容
         * @author daimq 
         * @param compressedStr
         * @return 
         * @since JDK 1.6
         */
        public static String unGzip(String compressedStr){
            if(StringUtils.isEmpty(compressedStr)){
                return null;
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = null;
            GZIPInputStream ginzip = null;
            byte[] compressed = null;
            try {
                compressed = new Base64().decode(compressedStr);
                in = new ByteArrayInputStream(compressed);
                ginzip = new GZIPInputStream(in);
    
                byte[] buffer = new byte[1024];
                int offset = -1;
                while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
                }
                return out.toString("UTF-8");
            } catch (IOException e) {
                LOG.error("ungzip err cause by:", e);
                return null;
            } finally {
                if (ginzip != null) {
                    try {
                        ginzip.close();
                    } catch (IOException e) {
                        LOG.error("unGzip err when close ginzip cause by", e);
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        LOG.error("unGzip err when close in cause by", e);
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        LOG.error("unGzip err when close out cause by", e);
                    }
                }
            }
        }
        private Compressor(){
        }
}
