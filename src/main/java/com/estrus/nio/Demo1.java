package com.estrus.nio;


/**
 * 通过allocate()获取缓冲区
 *
 * put():存入数据到缓冲区
 * get():获取缓冲区数据
 *
 * capacity:容量 表示缓冲区的最大容量。一旦声明不能改变
 * limit:界限 表示缓冲区可以操作数据的大小。limit后的数据不能进行读写
 * position:位置 表示缓冲区中正在操作数据的位置
 * mark:标记，表示记录当前position的位置，可以通过reset()恢复到mark的位置
 * 0 <= mark <= position <= limit <= capacity
 *
 *
 */

import org.junit.Test;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.time.LocalTime;

/**
 * @author hanzhanzhao
 */
public class Demo1 {

    @Test
    public void test1(){
        String str = "abcde";
        System.out.println("---------allocate---------");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        buffer.put(str.getBytes());
        System.out.println("----------put-------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        buffer.flip(); // 切换到读数据模式
        System.out.println("----------flip------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        byte[] bt = new byte[buffer.limit()];
        buffer.get(bt);
        System.out.println(new String(bt,0,bt.length));
        System.out.println("----------get------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        buffer.rewind();//重复读
        System.out.println("----------rewind------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        buffer.clear();//清空缓冲区，但是缓冲区数据还在，处于被遗忘状态
        System.out.println("----------clear------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //数据还是可以get到 只是位置、界限 全部改变了
        System.out.println((char)(buffer.get(2)));
    }

    @Test
    public void test2(){
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        byte[] dst = new byte[buffer.limit()];
        buffer.flip(); //切换到读读数据模式 position为0
        buffer.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buffer.position());
        buffer.mark();//标记位置
        buffer.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buffer.position());
        buffer.reset();//position回到标记的位置
        System.out.println(buffer.position());
        //缓冲区是否还有可以操作的数据  （position < limit）
        if (buffer.hasRemaining()){
            //获取缓冲区可以操作的数量（limit-position）
            System.out.println(buffer.remaining());
        }
    }

    @Test
    public void test3(){
        //直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());
    }
}
