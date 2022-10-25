package com.jago;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class V022_Shell {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a){
        //1-根据数组a的长度确定增长量h的初始值
        int h = 1;
        while (h < a.length/2){
            h = 2*h + 1;
        }
        //2-进行希尔排序
        while (h >= 1){
            //排序
            //2.1.找到待插入的元素（根据数组分析，第一个待插入的值是数组中索引为a[h]）
            for (int i = h; i < a.length; i++) {
                //2.2.把待插入的元素插入到有序数列中
                for (int j = i; j >=h ; j-=h) {
                    //j索引就是待插入元素,类似插入排序，一直往前找，把元素放到合适位置
                    //这里很类似插入排序的内循环，不过插入排序的h为1
                    //待插入的元素为a[j]，比较a[j-h]和a[j]的值
                    if (greater(a[j-h],a[j])) exch(a,j-h,j);
                    else break;
                }
            }
            //减少h的值
            h = h/2;
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
