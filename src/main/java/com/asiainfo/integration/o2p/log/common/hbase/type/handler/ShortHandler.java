package com.asiainfo.integration.o2p.log.common.hbase.type.handler;

import org.apache.hadoop.hbase.util.Bytes;

import com.asiainfo.integration.o2p.log.common.hbase.type.AbstractTypeHandler;




/**
 * @author xinzhi
 * */
public class ShortHandler extends AbstractTypeHandler {

	@Override
	protected boolean aboutToHandle(Class<?> type) {
		return type == short.class || type == Short.class;
	}

	@Override
	protected byte[] innerToBytes(Class<?> type, Object value) {
		return Bytes.toBytes((Short) value);
	}

	@Override
	protected Object innerToObject(Class<?> type, byte[] bytes) {
		return Bytes.toShort(bytes);
	}
}
