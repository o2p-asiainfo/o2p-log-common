package com.asiainfo.integration.o2p.log.common.hbase.type.handler;

import org.apache.hadoop.hbase.util.Bytes;

import com.asiainfo.integration.o2p.log.common.hbase.type.AbstractTypeHandler;




/**
 * @author xinzhi
 * */
public class EnumHandler extends AbstractTypeHandler {

	@Override
	protected boolean aboutToHandle(Class<?> type) {
		return type.isEnum();
	}

	@Override
	protected byte[] innerToBytes(Class<?> type, Object value) {
		String name = ((Enum<?>) value).name();
		return Bytes.toBytes(name);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Object innerToObject(Class type, byte[] bytes) {
		String name = Bytes.toString(bytes);
		return Enum.valueOf(type, name);
	}
}
