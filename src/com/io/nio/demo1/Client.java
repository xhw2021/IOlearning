package com.io.nio.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description 基于NIO的非阻塞性客户端实现
 * @Author 22936
 * @Date 2021/5/4 11:24
 * @Version 1.0
 */

public class Client {

    public static void main(String[] args) throws Exception {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
        sChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //发送数据给服务端
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("请说：");
            String msg = sc.nextLine();

            buffer.put(msg.getBytes());
            buffer.flip();
            sChannel.write(buffer);
            buffer.clear();
        }

    }
}
