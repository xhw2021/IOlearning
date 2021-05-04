package com.io.bio.demo2;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 20:10
 * @Description: 客户端可以反复发送消息
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",9999);
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("请输入：");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }

    }
}
