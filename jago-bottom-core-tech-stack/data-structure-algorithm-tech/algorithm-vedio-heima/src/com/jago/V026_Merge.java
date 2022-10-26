package com.jago;

/**
 * 归并排序
 */
public class V026_Merge {
    //归并所需要的辅助数组
    private static Comparable[] assist;


    //对数组a的元素进行排序
   public static void sort(Comparable [] a){

   }
   //对数组中从lo到hi的元素进行排序
   private static void sort(Comparable[] a,int lo,int hi){

   }

   //数组中0-lo组和lo+1到hi的两组元素进行合并
    private static void merge(Comparable[] a,int lo,int mid,int hi){
       
    }


    //比较元素v是否小于元素w
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    //数组元素i和j交换位置
    private static void exch(Comparable[] a,int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
