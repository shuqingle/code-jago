package com.jago;

import java.util.Arrays;

/**
 * 归并排序(归并没有希尔快)
 */
public class V026_Merge {
    //归并所需要的辅助数组
    private static Comparable[] assist;


    //对数组a的元素进行排序
   public static void sort(Comparable [] a){
        //1-初始化辅助数组assist
       assist = new Comparable[a.length];
       //2-定义lo和hi，分别记录数组中最小的索引和最大的索引
       int lo = 0;
       int hi = a.length-1;
       //3-调用sort重载方法完成数组a中，从索引Lo到hi的元素排序
       sort(a,lo,hi);
   }
   //对数组中从lo到hi的元素进行排序
   private static void sort(Comparable[] a,int lo,int hi){
        //1-做安全性校验
       if (hi <= lo) return;
       //2-对lo到hi之间的数据进行分组，分为两个组
       int mid = lo+(hi-lo)/2;
       //3-对两个组进行排序
       sort(a,lo,mid);
       sort(a,mid+1,hi);
       //4-对两个组进行归并
       merge(a,lo,mid,hi);
   }

   //数组中0-lo组和lo+1到hi的两组元素进行合并
    private static void merge(Comparable[] a,int lo,int mid,int hi){
       //1-定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid+1;
        //2-遍历移动p1指针和p2指针，比较对应索引处的值，找出小的，放到辅助assist数组的对应索引处
        while (p1<=mid && p2 <=hi){
            //比较对应索引处的值
            // 放完后i和p都后移一位
            if (less(a[p1],a[p2])) assist[i++] = a[p1++];
            else assist[i++] = a[p2++];
        }
        //《----能走到下面表示上面的while条件不满足，表示有一个子数组已经遍历比较完了，没遍历完的不再不需要比较了----》
        //3-遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p1 <= mid){
            assist[i++] = a[p1++];
        }
        //4-遍历，如果p2的指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p2 <= hi){
            assist[i++] = a[p2++];
        }
        //5-把辅助数组中元素拷贝到原数组中
        for (int j = lo; j <=hi ; j++) {
            a[j] = assist[j];
        }
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

    public static void main(String[] args) {
        Integer [] a = new Integer[]{3,1,6,5,4,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
