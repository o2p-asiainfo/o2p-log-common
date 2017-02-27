package com.asiainfo.integration.o2p.log.common.hbase.type.handler;

import org.apache.hadoop.hbase.util.Bytes;

import com.asiainfo.integration.o2p.log.common.hbase.type.AbstractTypeHandler;






/**
 * @author xinzhi
 * */
public class BooleanHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == boolean.class || type == Boolean.class;
    }

    @Override
    protected byte[] innerToBytes(Class<?> type, Object value) {
        return Bytes.toBytes((Boolean) value);
    }

    @Override
    protected Object innerToObject(Class<?> type, byte[] bytes) {
        return Bytes.toBoolean(bytes);
    }

}
