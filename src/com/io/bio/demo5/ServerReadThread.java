package com.io.bio.demo5;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 21:55
 * @Description:
 */
public class ServerReadThread extends Thread {
    private Socket socket;

    public ServerReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String suffix = dis.readUTF();
            System.out.println("服务端接受到了文件类型为："+suffix);
            //定义字节输出管道负责把客户端发来的文件数据写出去
            OutputStream os = new FileOutputStream("E:\\Code\\JavaLearning\\IO\\src\\com\\IO\\BIO\\服务器路径\\"
                    + UUID.randomUUID().toString()+suffix);
            byte[] buffer = new byte[1024];
            int len;
            while((len = dis.read(buffer)) >0){
                os.write(buffer,0,len);
            }
            os.close();
            System.out.println("服务端保存数据成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
