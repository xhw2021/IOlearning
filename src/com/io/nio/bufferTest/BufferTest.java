package com.io.nio.bufferTest;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @ClassName BufferTest
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/4 9:55
 * @Version 1.0
 */

public class BufferTest {

    @Test
    public void test01(){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        String name = "xuhewu";
        buffer.put(name.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.flip(); //设置为可读模式
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        char ch = (char)buffer.get();
        System.out.println(ch);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


    }

    @Test
    public void test02(){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("---------------------------------");

        String name = "xuhewu";
        buffer.put(name.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("----------------------------------");

        buffer.clear();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println((char)buffer.get());
        System.out.println("----------------------------------");

        ByteBuffer buf = ByteBuffer.allocate(10);
        String n = "hahaha";
        buf.put(n.getBytes());

        buf.flip();

        byte[] b = new byte[2];
        buf.get(b);
        String rs = new String(b);
        System.out.println(rs);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println("----------------------------------");

        buf.mark(); // 标记此刻的位置
        byte[] b2 = new byte[3];
        buf.get(b2);
        System.out.println(new String(b2));
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println("----------------------------------");

        buf.reset(); // 回到标记位置
        if(buf.hasRemaining()){
            System.out.println(buf.remaining());
        }

    }


}
