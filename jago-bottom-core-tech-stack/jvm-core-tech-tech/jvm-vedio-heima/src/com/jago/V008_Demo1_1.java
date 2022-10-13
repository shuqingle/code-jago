package com.jago;

/**
 * 演示栈帧
 */
public class V008_Demo1_1 {
    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        m2(1,2);
    }

    private static int m2(int a, int b) {
        int c = a + b;
        return c;
    }
}
