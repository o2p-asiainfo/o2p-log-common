/** 
 * Project Name:stormDemo 
 * File Name:SrpingContext.java 
 * Package Name:com.ai.mine.util 
 * Date:2015年8月24日下午11:12:05 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.log.common.util;  

import java.io.File;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/** 
 * ClassName:SrpingContext  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2015年8月24日 下午11:12:05  
 * @author   daimq 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public final class SpringContext{

    private static ApplicationContext propertiesContext;
    private static ApplicationContext beansContext;
    private static String fileName;
    static{
    	File f = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath()+"/logQuery-application.xml");
    	if(f.exists()){
    		fileName = "classpath:logQuery-application.xml";
    	}else{
    		fileName = "classpath:stormRMDB-ds.xml";
    	}
    }
    
    public static ApplicationContext getPropertiesContext() {
        return propertiesContext;
    }
    public static void setPropertiesContext(ApplicationContext propertiesContext) {
        SpringContext.propertiesContext = propertiesContext;
    }
    public static ApplicationContext getBeansContext() {
        if(beansContext == null){
            GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
            ctx.getEnvironment().setActiveProfiles(Properties.getInstance().getDatabaseType());
            ctx.load(fileName);
            ctx.refresh();
            SpringContext.setBeansContext(ctx);
        }
        return beansContext;
    }
    public static void setBeansContext(ApplicationContext beansContext) {
        SpringContext.beansContext = beansContext;
    }
    
    private SpringContext(){
    }
    
}
