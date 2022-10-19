package com.jago;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示GC Root
 */
public class V051_Demo2_2 {
    public static void main(String[] args) throws IOException {
        List<Object> list1 = new ArrayList<>();//通过MAT，list可以作为根对象
        list1.add("a");
        list1.add("b");
        System.out.println(1);
        System.in.read();
        list1 = null;
        System.out.println(2);
        System.in.read();
        System.out.println("end...");
    }
}
