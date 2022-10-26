package com.jago;

import java.util.Arrays;

/**
 * 快速排序
 */
public class V033_Quick {
    //对数组a的元素进行排序
    public static void sort(Comparable [] a){
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }
    //对数组中从lo到hi的元素进行排序
    private static void sort(Comparable[] a,int lo,int hi){
        //1-安全性校验
        if (lo >= hi) return;
        //2-需要对数组中lo索引到hi处的元素进行分组（左右子组）
        //返回的是分界值位置变换后的索引
        int partition = partition(a, lo, hi);//返回原初始数组0位置的数字的排序后的最新索引
        //让左子组有序
        sort(a,lo,partition-1);
        //让右子组有序
        sort(a,partition+1,hi);
    }
    //对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a,int lo,int hi){
        //1-确定分界值
        Comparable key = a[lo];
        //2-定义两个指针，分别指向待切分数组最小索引和最大索引的下一个位置
        int left = lo;
        int right = hi + 1;
        //3-切分：
        while (true){
            //3.1先从右往左扫描，移动riht指针，找到一个比分界值小的元素，然后停止
            while (less(key,a[--right])) if (right == lo) break;
            //3.2然后从左往右扫描，移动left指针，找到一个比分界值大的元素，然后停止
            while (less(a[++left],key)) if (left == hi) break;
            //3.3 判断left>=right，如果是，则证明元素扫描结束，否则交换元素
            if (left >= right) break;
            else exch(a,left,right);//left比right大
        }//4-交换分界值,此时left==right
        exch(a,lo,right);
        return right;
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
