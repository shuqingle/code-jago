package com.jago;

import java.util.Arrays;

/**
 * 选择排序
 */
public class V015_Selection {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a){
        for (int i = 0; i <a.length-1; i++) {
            //假定本次遍历，最小值所在的索引是i
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (greater(a[minIndex],a[j])) minIndex = j;
            }
            exch(a,i,minIndex);
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
        System.out.println(Arrays.toString(a));
    }
}
