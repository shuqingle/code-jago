package com.jago;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class V013_Bubble {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a){
        for (int i = a.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j],a[j+1])) exch(a,j,j+1);
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (greater(a[j],a[j+1])) exch(a,j,j+1);
            }
        }

    }

   //比较元素是否大于w元素
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    //数组元素i和j元素交换
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Integer [] a = new Integer[]{3,1,6,5,4,2};
        sort(a);
        Arrays.toString(a);
    }
}
