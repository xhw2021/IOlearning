package com.io.bio.demo4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 21:20
 * @Description: 开发实现伪异步通信架构
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            HandlerSocketServerPool pool = new HandlerSocketServerPool(6,10);
            while(true){
                Socket socket = ss.accept();
                // 把socket封装成任务对象再交给线程池处理
                Runnable target = new ServerRunnableTarget(socket);
                pool.execute(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
