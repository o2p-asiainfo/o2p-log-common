package com.asiainfo.integration.o2p.log.common.solr;

import org.apache.solr.client.solrj.impl.BinaryRequestWriter;
import org.apache.solr.client.solrj.impl.HttpSolrServer;;



public class SolrServer {
	
	
    private String solrServerUrl;
	
    private int soTimeout;
	
    private int connectionTimeout;
	
    private int defaultMaxConnectionsPerHost;
	
    private int maxTotalConnections;
	
    private boolean followRedirects;
	
    private boolean allowCompression;
	
    private int maxRetries;
	
	
	public String getSolrServerUrl() {
		return solrServerUrl;
	}

	public void setSolrServerUrl(String solrServerUrl) {
		this.solrServerUrl = solrServerUrl;
	}

	public int getSoTimeout() {
		return soTimeout;
	}

	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getDefaultMaxConnectionsPerHost() {
		return defaultMaxConnectionsPerHost;
	}

	public void setDefaultMaxConnectionsPerHost(int defaultMaxConnectionsPerHost) {
		this.defaultMaxConnectionsPerHost = defaultMaxConnectionsPerHost;
	}

	public int getMaxTotalConnections() {
		return maxTotalConnections;
	}

	public void setMaxTotalConnections(int maxTotalConnections) {
		this.maxTotalConnections = maxTotalConnections;
	}

	public boolean isFollowRedirects() {
		return followRedirects;
	}

	public void setFollowRedirects(boolean followRedirects) {
		this.followRedirects = followRedirects;
	}

	public boolean isAllowCompression() {
		return allowCompression;
	}

	public void setAllowCompression(boolean allowCompression) {
		this.allowCompression = allowCompression;
	}

	public int getMaxRetries() {
		return maxRetries;
	}

	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	public HttpSolrServer getServer() {
		return server;
	}

	public void setServer(HttpSolrServer server) {
		this.server = server;
	}

	HttpSolrServer server;
	 
	// 多线程共享
	public HttpSolrServer getCommonsHttpSolrServer() {
		
		if(server == null){
			server = new HttpSolrServer(solrServerUrl);
			server.setSoTimeout(soTimeout);
			server.setConnectionTimeout(connectionTimeout);
			server.setDefaultMaxConnectionsPerHost(defaultMaxConnectionsPerHost);
			server.setMaxTotalConnections(maxTotalConnections);
			server.setFollowRedirects(followRedirects);
			server.setAllowCompression(allowCompression);
			server.setMaxRetries(maxRetries);
			server.setRequestWriter(new BinaryRequestWriter());
		}
		return server;
	}


	
	

}
