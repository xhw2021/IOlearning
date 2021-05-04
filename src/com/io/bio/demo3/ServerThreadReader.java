package com.io.bio.demo3;

import java.io.*;
import java.net.Socket;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 20:51
 * @Description: 每接受一个socket，创建一个线程
 */
public class ServerThreadReader extends Thread {
    private Socket socket;

    public ServerThreadReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while((msg = br.readLine())!= null){
                System.out.println("服务器收到："+ msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
