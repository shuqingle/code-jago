package com.jago;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示直接内存溢出
 * OutOfMemoryError: Direct buffer memory
 */
public class V043_Demo1_10 {
    static int _100Mb = 1024*1024*100;
    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i=0;
        try {
            while (true){
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100Mb);
                list.add(byteBuffer);
                i++;
            }
        }finally {
            System.out.println(i);
        }
    }
}
