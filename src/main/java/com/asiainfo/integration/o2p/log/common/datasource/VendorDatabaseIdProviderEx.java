package com.asiainfo.integration.o2p.log.common.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;

import com.ailk.eaap.o2p.common.spring.config.ZKCfgCacheHolder;

public class VendorDatabaseIdProviderEx extends VendorDatabaseIdProvider {
	
	@Override
	 public String getDatabaseId(DataSource dataSource) {
		return ZKCfgCacheHolder.PROP_ITEMS.get("databaseId")==null?"mysql":ZKCfgCacheHolder.PROP_ITEMS.get("rmdbType").toString();
	}
}
