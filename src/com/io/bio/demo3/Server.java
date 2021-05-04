package com.io.bio.demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 20:10
 * @Description: 服务端实现同时接受多个客户端的socket通信需求
 *                  每接收到一个不同socket就创建一个新的线程处理
 *
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            // 不断接受客户端的socket连接请求
            while(true){
                Socket socket = ss.accept();
                new ServerThreadReader(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
