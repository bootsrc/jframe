package com.bootsrc.nio;

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
        /*
            使用Buffer读写数据一般需要循环执行以下四个步骤：
            1.写入数据到Buffer
            2.调用flip()方法
            3.从Buffer中读取数据
            4.调用compact()方法
        */

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
