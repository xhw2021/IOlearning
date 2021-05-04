package com.io.bio.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 20:10
 * @Description: 客户端
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",9999);
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("hello world!"); //如果不是println，服务端会因为客户端挂掉而连接重置
        ps.flush();

    }
}
