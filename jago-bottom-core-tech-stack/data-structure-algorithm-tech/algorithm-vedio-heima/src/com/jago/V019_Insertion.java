package com.jago;

import java.util.Arrays;

/**
 * 插入排序
 */
public class V019_Insertion {
    //对数组a中的元素进行排序
    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0 ; j--) {//如果j=0则j-1数组越界
                //比较索引j处的值和索引j-1处的值
                //如果索引j-1处的值比j处的值，则交换数据，否则找到合适位置，退出内存循环
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
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
        System.out.println(Arrays.toString(a));
    }
}
