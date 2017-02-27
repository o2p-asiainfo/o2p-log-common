package com.asiainfo.integration.o2p.log.common.hbase.type.handler;

import org.apache.hadoop.hbase.util.Bytes;

import com.asiainfo.integration.o2p.log.common.hbase.type.AbstractTypeHandler;




/**
 * @author xinzhi
 * */
public class FloatHandler extends AbstractTypeHandler {

	@Override
	protected boolean aboutToHandle(Class<?> type) {
		return type == float.class || type == Float.class;
	}

	@Override
	protected byte[] innerToBytes(Class<?> type, Object value) {
		return Bytes.toBytes((Float) value);
	}

	@Override
	protected Object innerToObject(Class<?> type, byte[] bytes) {
		return Bytes.toFloat(bytes);
	}
}
