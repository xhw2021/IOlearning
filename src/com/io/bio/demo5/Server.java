package com.io.bio.demo5;

import com.IO.BIO.demo4.ServerRunnableTarget;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 21:42
 * @Description: 服务端实现接受客户端的任意类型文件，并保存到服务端磁盘
 */
public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(9999);
            while(true){
                Socket socket = ss.accept();
                new ServerReadThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
