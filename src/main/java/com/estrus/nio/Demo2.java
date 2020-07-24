package com.estrus.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 *
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 *
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 *
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 *
 */
public class Demo2 {

    @Test
    public void test6() throws Exception {
        Charset cs1 = Charset.forName("GBK");
        //编码器
        CharsetEncoder ce = cs1.newEncoder();
        //解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer buf = CharBuffer.allocate(1024);
        buf.put("召哥真的帅！");
        buf.flip();
        ByteBuffer byteBuffer = ce.encode(buf);
        for (int i=0;i<12;i++){
            System.out.println(byteBuffer.get());
        }
        byteBuffer.flip();
        CharBuffer decode = cd.decode(byteBuffer);
        System.out.println(decode.toString());

        Charset cs2 = Charset.forName("GBK");
        byteBuffer.flip();
        CharBuffer cb = cs2.decode(byteBuffer);
        System.out.println(cb);


    }

    @Test
    public void test5() throws Exception {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String,Charset>> set = map.entrySet();
        for (Map.Entry<String,Charset> entry : set){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    @Test
    public void test4() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("d:/1.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        //分散读取
        ByteBuffer[] bufs = {buf1,buf2};
        channel.read(bufs);
        for (ByteBuffer byteBuffer : bufs){
            byteBuffer.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("==========");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
        //聚集写入
        RandomAccessFile rf2 = new RandomAccessFile("d:/2.txt", "rw");
        FileChannel channel1 = rf2.getChannel();
        channel1.write(bufs);
        channel1.close();

    }

    //通道之间的数据传输(直接缓冲区)
    @Test
    public void test3() throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get("d:/1.avi"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("d:2.avi"), StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    //使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get("d:/1.avi"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("d:2.avi"), StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        byte[] dts = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dts);
        outMappedBuf.put(dts);
        inChannel.close();
        outChannel.close();
    }

    //利用通道完成文件的复制（非直接缓冲区）
    @Test
    public void test1() throws Exception {
        FileInputStream fis = new FileInputStream("d:/1.jpg");
        FileOutputStream fos = new FileOutputStream("d:/2.jpg");
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //将通道中的数据存入缓冲区
        while (inChannel.read(buf)!=-1){
            //切换读取数据的模式
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        outChannel.close();;
        inChannel.close();;
        fos.close();;
        fis.close();
    }
}
