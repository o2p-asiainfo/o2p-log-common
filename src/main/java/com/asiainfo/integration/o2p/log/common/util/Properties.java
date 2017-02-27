/** 
 * Project Name:realTimeLog 
 * File Name:Properties.java 
 * Package Name:com.asianinfo.log.utils 
 * Date:2015年9月25日下午3:34:01 
 * Copyright (c) 2015, www.asiainfo.com All Rights Reserved. 
 * 
 */

package com.asiainfo.integration.o2p.log.common.util;

import java.io.File;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:Properties Function: TODO ADD FUNCTION. Reason: TODO ADD REASON.
 * Date: 2015年9月25日 下午3:34:01
 * 
 * @author daimq
 * @version
 * @since JDK 1.6
 * 
 */
public final class Properties {

	private String activeMqURL;
	private String activeMqQueue;
	private String activeMqUsename;
	private String activeMqPassword;

	private String databaseType;
	private Boolean isHbaseType;

	private String workNum;
	private String spoutThreadNum;
	private String storeBoltThreadNum;
	private String statSplitThreadNum;
	private String statGroupThreadNum;

	private String statGroupStoreThreadNum;

	private String batchNum;

	private String ifFormatUTC;

	private String internalTime;

	private String spoutSleepTime;

	private String rmdbType;
	private static String fileName;
	private String exceptionDestination;
	static {
		File f = new File(Thread.currentThread().getContextClassLoader()
				.getResource("").getPath()
				+ "/queryProperties.xml");
		if (f.exists()) {
			fileName = "classpath:queryProperties.xml";
		} else {
			fileName = "classpath:stormProperties.xml";
		}
	}

	public String getRmdbType() {
		return rmdbType;
	}

	public void setRmdbType(String rmdbType) {
		this.rmdbType = rmdbType;
	}

	private Properties() {

	}

	public String getActiveMqURL() {
		return activeMqURL;
	}

	public void setActiveMqURL(String activeMqURL) {
		this.activeMqURL = activeMqURL;
	}

	public String getActiveMqQueue() {
		return activeMqQueue;
	}

	public void setActiveMqQueue(String activeMqQueue) {
		this.activeMqQueue = activeMqQueue;
	}

	public String getActiveMqUsename() {
		return activeMqUsename;
	}

	public void setActiveMqUsename(String activeMqUsename) {
		this.activeMqUsename = activeMqUsename;
	}

	public String getActiveMqPassword() {
		return activeMqPassword;
	}

	public void setActiveMqPassword(String activeMqPassword) {
		this.activeMqPassword = activeMqPassword;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	public Boolean getIsHbaseType() {
		return isHbaseType;
	}

	public void setIsHbaseType(Boolean isHbaseType) {
		this.isHbaseType = isHbaseType;
		if (getIsHbaseType() == true) {
			setDatabaseType("nosql");
		} else {
			setDatabaseType("rmdb");
		}
	}

	public String getWorkNum() {
		return workNum;
	}

	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

	public String getSpoutThreadNum() {
		return spoutThreadNum;
	}

	public void setSpoutThreadNum(String spoutThreadNum) {
		this.spoutThreadNum = spoutThreadNum;
	}

	public String getStoreBoltThreadNum() {
		return storeBoltThreadNum;
	}

	public void setStoreBoltThreadNum(String storeBoltThreadNum) {
		this.storeBoltThreadNum = storeBoltThreadNum;
	}

	public String getStatSplitThreadNum() {
		return statSplitThreadNum;
	}

	public void setStatSplitThreadNum(String statSplitThreadNum) {
		this.statSplitThreadNum = statSplitThreadNum;
	}

	public String getStatGroupThreadNum() {
		return statGroupThreadNum;
	}

	public void setStatGroupThreadNum(String statGroupThreadNum) {
		this.statGroupThreadNum = statGroupThreadNum;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getIfFormatUTC() {
		return ifFormatUTC;
	}

	public void setIfFormatUTC(String ifFormatUTC) {
		this.ifFormatUTC = ifFormatUTC;
	}

	public String getInternalTime() {
		return internalTime;
	}

	public void setInternalTime(String internalTime) {
		this.internalTime = internalTime;
	}

	public String getSpoutSleepTime() {
		return spoutSleepTime;
	}

	public void setSpoutSleepTime(String spoutSleepTime) {
		this.spoutSleepTime = spoutSleepTime;
	}

	public String getStatGroupStoreThreadNum() {
		return statGroupStoreThreadNum;
	}

	public void setStatGroupStoreThreadNum(String statGroupStoreThreadNum) {
		this.statGroupStoreThreadNum = statGroupStoreThreadNum;
	}

	public String getExceptionDestination() {
		return exceptionDestination;
	}

	public void setExceptionDestination(String exceptionDestination) {
		this.exceptionDestination = exceptionDestination;
	}

	public static Properties getInstance() {
		if (SpringContext.getPropertiesContext() == null) {
			ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext(
					fileName);
			SpringContext.setPropertiesContext(ct);
		}
		return (Properties) SpringContext.getPropertiesContext().getBean(
				"confProps");
	}

}
