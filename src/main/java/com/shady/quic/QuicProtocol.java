package com.shady.quic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteOrder;

/**
 * QUIC Packet Header is 20 byte
 *
 * Created by shady on 29/05/15.
 */
public class QuicProtocol {
    private QuicProtocol() {}

    public static ByteBuf getStandardHeader(){
        ByteBuf bb = Unpooled.buffer(1, 20).order(ByteOrder.LITTLE_ENDIAN);

        //public flags
        bb.writeByte(0b00001101);

        //connection id 8 byte
        bb.writeLong(123);

        //quic version 4 bytes
        bb.writeByte('Q'); //Q
        bb.writeByte('0'); //0
        bb.writeByte('2'); //1
        bb.writeByte('5'); //5

        //sequence number 6 bytes
        bb.writeByte(1);

        //private flags
        bb.writeByte(0);

        //
        return bb;
    }
}
