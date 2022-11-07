package com.jago;

/**
 * finally中return吞掉异常
 */
public class V127_Demo3_12_1 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    private static int test(){
        try {
            int a = 1/0;
            return 10;
        }finally {
            return 20;
        }
    }
}
