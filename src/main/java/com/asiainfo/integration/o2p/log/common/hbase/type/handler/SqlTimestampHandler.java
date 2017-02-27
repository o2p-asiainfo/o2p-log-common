package com.asiainfo.integration.o2p.log.common.hbase.type.handler;

import java.sql.Timestamp;

import org.apache.hadoop.hbase.util.Bytes;

import com.asiainfo.integration.o2p.log.common.hbase.type.AbstractTypeHandler;




/**
 * 
 * @author 颖勤
 *
 */
public class SqlTimestampHandler extends AbstractTypeHandler{

	@Override
	protected boolean aboutToHandle(Class<?> type) {
		return type == java.sql.Timestamp.class || type == java.sql.Timestamp.class;
	}

	@Override
	protected byte[] innerToBytes(Class<?> type, Object value) {
		java.sql.Timestamp ts = (Timestamp) value;
		return Bytes.toBytes(ts.getTime());
	}

	@Override
	protected Object innerToObject(Class<?> type, byte[] bytes) {
		return Bytes.toLong(bytes);
	}

}
