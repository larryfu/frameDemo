package com.tencent.lucas.demo.protouf;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * Created by lucasfu on 2016/11/23.
 */
public class ProtoBase {

    public Schema getSchema() {
        return RuntimeSchema.getSchema(this.getClass());
    }

    public byte[] toByteArray() {
        LinkedBuffer buffer = LinkedBuffer.allocate(1024);
        byte[] bytes = ProtostuffIOUtil.toByteArray(this, getSchema(), buffer);
        return bytes;
    }

    public void merageFrom(byte[] bytes) {
        ProtostuffIOUtil.mergeFrom(bytes, this, getSchema());
    }

}
