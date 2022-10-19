package com.jago;

import java.util.Scanner;

/**
 * 统计字符串每个字符的数量
 */
public class B454_Count {
    public static void main(String[] args) {
        B453_Alphabet alpha = new B453_Alphabet(args[0]);
        int R = alpha.R();
        int [] count = new int[R];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (alpha.contains(s.charAt(i))) count[alpha.toIndex(s.charAt(i))]++;
        }
        for (int c = 0; c < R; c++) {
            System.out.println(alpha.toChar(c)+" " + count[c]);
        }
    }
}
