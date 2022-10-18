package com.jago;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 演示直接内存会被会被GC回收
 */
public class V044_Demo1_26 {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024*1024*1024);
        System.out.println("分配完毕");
        System.in.read();
        System.out.println("开始释放");
        byteBuffer = null;
        System.gc();
        System.in.read();
    }
}
