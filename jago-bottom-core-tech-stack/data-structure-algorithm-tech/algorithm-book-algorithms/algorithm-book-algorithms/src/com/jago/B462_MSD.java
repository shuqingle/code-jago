package com.jago;

/**
 * 高位优先字符串排序
 */
public class B462_MSD {
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;
    private static int charAt(String s,int d){
        if (d < s.length()){
            return s.charAt(d);
        }else {
            return -1;
        }
    }

    /**
     *
     * B
     * ABD
     * AB
     * A
     * AC
     * ABE
     *
     * @param a
     */
    public static void sort(String [] a){
        int N = a.length;
        aux = new String[N];
        sort(a,0,N-1,0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <=lo + M){
            Insertion.sort(a,lo,hi,d); return;
        }
        int [] count = new int[R+2];
        //计算频率
        for (int i = lo; i <=hi ; i++) {
            count[charAt(a[i],d)+2]++;
        }
        //频率转换为索引
        for (int r = 0; r < R+1; r++) {
            count[r+1] += count[r];
        }
        //数据分类
        for (int i = lo; i <=hi ; i++) {
            aux[count[charAt(a[i],0)+1]++] = a[i];
        }
        //回写
        for (int i = lo; i <=hi ; i++) {
            a[i] = aux[i-lo];
        }
        //递归的以每个字符为键进行排序
        for (int r = 0; r < R; r++) {
            sort(a,lo+count[r],lo+count[r+1]-1,d+1);
        }

    }


}

//插入排序
 class Insertion{
    public static void sort(String[] a, int lo, int hi, int d){

    }
}