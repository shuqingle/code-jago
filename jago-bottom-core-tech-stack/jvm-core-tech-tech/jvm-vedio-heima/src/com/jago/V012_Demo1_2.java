package com.jago;

/**
 * 栈帧过多，导致栈内存溢出 StackOverflowError
 * -Xss256k
 */
public class V012_Demo1_2 {
    private static int count;

    public static void main(String[] args) {
        try{
            m1();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void m1() {
        count++;
        m1();
    }
}
