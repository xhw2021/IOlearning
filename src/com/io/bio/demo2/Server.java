package com.io.bio.demo2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 20:10
 * @Description: 服务端不断的接受消息
 *
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("++服务端启动++");
            Socket socket = ss.accept();

            //从socket中得到字节输入流
            InputStream is = socket.getInputStream();
            //把字节输入流包装成缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while((msg = br.readLine()) != null){
                System.out.println("服务端接收到：" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
