package com.io.bio.demo5;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 21:43
 * @Description: 客户端上传任意类型的文件给服务端
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF(".png"); // 发送后缀

            InputStream is = new FileInputStream("F:\\GoogleDownload\\大厂面试之IO模式详解资料\\文件\\java.png");

            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) > 0){
                dos.write(buffer,0,len);
            }
            dos.flush();
            socket.shutdownOutput(); //防止服务端一直等待
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
