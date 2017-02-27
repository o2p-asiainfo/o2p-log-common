package com.asiainfo.integration.o2p.log.common.hbase.type.handler;

import com.asiainfo.integration.o2p.log.common.hbase.type.AbstractTypeHandler;




/**
 * @author xinzhi
 * */
public class ByteHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == byte.class || type == Byte.class;
    }

    @Override
    protected byte[] innerToBytes(Class<?> type, Object value) {
        return new byte[] { ((Byte) value).byteValue() };

    }

    @Override
    protected Object innerToObject(Class<?> type, byte[] bytes) {
       // Util.checkLength(bytes, 1);
        return bytes[0];
    }
}
