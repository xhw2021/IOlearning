package com.io.bio.demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 20:10
 * @Description: 服务端
 * 目标：客户端发送消息，服务端接受消息
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);

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
