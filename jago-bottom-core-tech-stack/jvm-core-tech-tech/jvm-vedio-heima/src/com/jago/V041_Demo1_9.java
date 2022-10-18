package com.jago;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 演示ByteBuffer使用直接内存
 */
public class V041_Demo1_9 {
    static final String FROM = "E:\\123.mp4";
    static final String TO = "D:\\a.mp4";
    static final int _1Mb = 1024*1024;

    public static void main(String[] args) {
        io();//io用时1500
        directBuffer();//directBuffer用时500
    }

    private static void directBuffer() {
        long start = System.nanoTime();
        try(
                FileChannel from = new FileInputStream(FROM).getChannel();
                FileChannel to = new FileOutputStream(TO).getChannel();
                ){
            ByteBuffer bb = ByteBuffer.allocateDirect(_1Mb);
            while (true){
                int len = from.read(bb);
                if (len == -1){
                    break;
                }
                bb.flip();
                to.write(bb);
                bb.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("directBuffer用时"+(end-start)/1000_000.0);
    }

    private static void io() {

    }
}
