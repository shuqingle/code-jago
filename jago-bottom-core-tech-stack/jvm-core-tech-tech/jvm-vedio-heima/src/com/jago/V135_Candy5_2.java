package com.jago;

import java.util.Arrays;
import java.util.List;

/**
 * 集合foreach循环语法糖
 */
public class V135_Candy5_2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
