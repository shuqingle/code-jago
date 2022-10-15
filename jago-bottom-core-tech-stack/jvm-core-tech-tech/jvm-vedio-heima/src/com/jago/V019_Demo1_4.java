package com.jago;

/**
 * 堆内存诊断：查看堆内存占用和释放情况
 */
public class V019_Demo1_4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1....");
        Thread.sleep(30000);
        byte[] array = new byte[1024*1024*10];//10MB
        System.out.println("2....");
        Thread.sleep(20000);
        array = null;
        System.gc();
        System.out.println("3.....");
        Thread.sleep(10000000000L);
    }
}
