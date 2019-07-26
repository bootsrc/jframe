package com.lsm.nio;

import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * nio在两个Channel之间传递数据
 */
public class ChannelCopy {
    public static void main(String[] args) throws Exception {
        ReadableByteChannel src = Channels.newChannel(System.in);
        WritableByteChannel des = Channels.newChannel(System.out);
        copy1(src, des);
        src.close();
        des.close();
    }

    private static void copy1(ReadableByteChannel src, WritableByteChannel des) throws Exception {

        ByteBuffer tmp = ByteBuffer.allocate(16 * 1024);
        while (src.read(tmp) != -1) {
            tmp.flip();
            des.write(tmp);
            tmp.compact();
        }
        tmp.flip();
        while (tmp.hasRemaining()) {
            des.write(tmp);
        }
    }

}
