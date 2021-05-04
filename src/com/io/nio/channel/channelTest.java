package com.io.nio.channel;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName channelTest
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/4 10:21
 * @Version 1.0
 */

public class channelTest {
    @Test
    public void Test01(){
        try {
            FileOutputStream fos = new FileOutputStream("src/com/io/nio/channel/data01.txt");

            FileChannel channel = fos.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put("hello!Nio!".getBytes());
            buf.flip();
            channel.write(buf);
            System.out.println("写数据到文件中！");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void Test02(){

        try {
            FileInputStream fis = new FileInputStream("src/com/io/nio/channel/data01.txt");
            FileChannel channel = fis.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            channel.read(buf);
            System.out.println(new String(buf.array()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void Test03() throws Exception {
        File srcFile = new File("G:\\code\\IOLearning\\src\\com\\io\\nio\\channel\\dog.gif");
        File destFile = new File("G:\\code\\IOLearning\\src\\com\\io\\nio\\channel\\dog1.gif");

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        FileChannel isChannel = fis.getChannel();
        FileChannel osChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (true){
            buf.clear();
            int flag = isChannel.read(buf);
            if(flag == -1){
                break;
            }
            buf.flip();
            osChannel.write(buf);
        }
        isChannel.close();
        osChannel.close();
        System.out.println("复制完成！");
    }


    @Test
    public void Test04() throws Exception {

        FileInputStream fis = new FileInputStream("src\\com\\io\\nio\\channel\\data01.txt");
        FileChannel isChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("src\\com\\io\\nio\\channel\\data02.txt");
        FileChannel osChannel = fos.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(2);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers ={buf1,buf2};

        isChannel.read(buffers);  // 分散

        for(ByteBuffer buf : buffers){
            buf.flip();
            System.out.println(new String(buf.array(),0,buf.remaining()));
        }

        osChannel.write(buffers); // 聚集

        isChannel.close();
        osChannel.close();

        System.out.println("复制完成！");
    }
}
