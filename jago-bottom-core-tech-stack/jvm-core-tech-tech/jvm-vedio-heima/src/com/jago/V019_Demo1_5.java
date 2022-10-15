package com.jago;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出：OutOfMemoryError: Java heap space
 */
public class V019_Demo1_5 {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true){
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {//不要Exception
            System.out.println(i);
            e.printStackTrace();
        }
    }
}
