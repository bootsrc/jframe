package com.bootsrc.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            ByteBuffer readBuffer = ByteBuffer.allocate(128);

            writeBuffer.put("client:hello".getBytes());
            writeBuffer.flip();

            while (true) {
                writeBuffer.rewind();
                socketChannel.write(writeBuffer);
                readBuffer.clear();
                socketChannel.read(readBuffer);
                readBuffer.flip();
                int rem = readBuffer.remaining();
                byte[] arr = new byte[rem];
                readBuffer.get(arr);
                System.out.println("receivedContent=" + new String(arr));

                String.valueOf(arr);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
        }
    }
}
