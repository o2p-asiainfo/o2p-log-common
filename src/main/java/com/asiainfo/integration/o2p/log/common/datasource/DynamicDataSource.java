package com.asiainfo.integration.o2p.log.common.datasource;

import java.io.Serializable;
import java.util.Map;

import javax.sql.DataSource;

import com.asiainfo.integration.o2p.log.common.bo.DataSourceObject;
import com.linkage.rainbow.dao.IMultiDataSourceRoute;
import com.linkage.rainbow.dao.MultiDataSource;

public class DynamicDataSource extends MultiDataSource implements Serializable {

	private static final long serialVersionUID = 1L;
	private DataSource dataSource = null;
	private Map<String, DataSource> datasourceMap = null;
	private IMultiDataSourceRoute multiDataSourceRoute;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Map<String, DataSource> getDatasourceMap() {
		return datasourceMap;
	}

	public void setDatasourceMap(Map<String, DataSource> datasourceMap) {
		this.datasourceMap = datasourceMap;
	}

	public IMultiDataSourceRoute getMultiDataSourceRoute() {
		return multiDataSourceRoute;
	}

	public void setMultiDataSourceRoute(IMultiDataSourceRoute multiDataSourceRoute) {
		this.multiDataSourceRoute = multiDataSourceRoute;
	}

	@Override
	public DataSource getDataSource(String dataSourceKey) {
		if (dataSourceKey == null || dataSourceKey.equals("")) {
			return this.dataSource;
		}
		if(datasourceMap==null){
			DataSource ds = new DataSourceObject();
			return ds;
		}
		return this.datasourceMap.get(dataSourceKey);

	}
}
