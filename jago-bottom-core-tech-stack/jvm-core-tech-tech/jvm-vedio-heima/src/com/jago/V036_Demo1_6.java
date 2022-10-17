package com.jago;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx10m -XX:-UseGCOverheadLimit
 * -Xmx10m报错：GC overhead limit exceeded
 * -Xmx10m -XX:-UseGCOverheadLimit报错：OutOfMemoryError: Java heap space
 */
public class V036_Demo1_6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            for (int j = 0; j < 260000000; j++) {
                list.add(String.valueOf(j).intern());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
