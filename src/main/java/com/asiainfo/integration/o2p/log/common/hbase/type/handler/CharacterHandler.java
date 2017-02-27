package com.asiainfo.integration.o2p.log.common.hbase.type.handler;

import com.asiainfo.integration.o2p.log.common.hbase.type.AbstractTypeHandler;




/**
 * @author xinzhi
 * */
public class CharacterHandler extends AbstractTypeHandler {

    @Override
    protected boolean aboutToHandle(Class<?> type) {
        return type == char.class || type == Character.class;
    }

    @Override
    protected byte[] innerToBytes(Class<?> type, Object value) {
        char c = ((Character) value).charValue();
        byte[] result = new byte[2];
        result[1] = (byte) c;
        result[0] = (byte) (c >>> 8);
        return result;
    }

    @Override
    protected Object innerToObject(Class<?> type, byte[] bytes) {
       // Util.checkLength(bytes, 2);

        int c = 0;
        c ^= (bytes[0] & 0xFF);
        c = c << 8;
        c ^= (bytes[1] & 0xFF);
        return (char) c;
    }
}
