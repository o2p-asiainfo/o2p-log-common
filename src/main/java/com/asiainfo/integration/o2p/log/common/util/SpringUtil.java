package com.asiainfo.integration.o2p.log.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 类名称 SpringUtil <br>
 * 日志服务端spring应用工具类
 * <p>
 * @version 1.0
 * @author linfeng 2013-2-1
 * <hr>
 * 修改记录
 * <hr>
 * 1、修改人员:    修改时间:<br>       
 *    修改内容:
 * <hr>
 */
public class SpringUtil implements ApplicationContextAware{
	
	//spring context (应用启动时设值)
	public static ApplicationContext context ;
	
	public static ApplicationContext getApplicationContext() {
		return context;
	}
	public static void setApplicationCtx(ApplicationContext ctx) throws BeansException{
	    context = ctx;
	}
	public  void setApplicationContext(ApplicationContext context) throws BeansException {

		this.context = context;
	}		
}