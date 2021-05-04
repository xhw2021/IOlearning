package com.io.nio.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @ClassName Server
 * @Description NIO非阻塞通信下的入门案例
 * @Author 22936
 * @Date 2021/5/4 11:11
 * @Version 1.0
 */

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);//配置非阻塞通道
        ssChannel.bind(new InetSocketAddress(9999)); //绑定端口
        Selector selector = Selector.open();
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);//将通道注册到选择器上，指定监听接收事件
        //使用selector选择器轮询就绪好的事件
        while(selector.select() > 0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey sk = iterator.next();
                if(sk.isAcceptable()){
                    SocketChannel accept = ssChannel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    SocketChannel sChannel = (SocketChannel)sk.channel();
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while((len = sChannel.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,buf.remaining()));
                        buf.clear();
                    }
                }
                iterator.remove();
            }
        }
    }
}
