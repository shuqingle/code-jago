package com.jago;

public class V023_SortCompareTest {
    public static void main(String[] args) {
        Integer[] a = getArray();
        testInsertion(a);
        testShell(a);
        testMerge(a);//shell 快于 merge
    }

    public static void testInsertion(Integer [] a){
        long start = System.currentTimeMillis();
        V019_Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("插入排序完成时间："+(end-start));
    }
    public static void testShell(Integer [] a){
        long start = System.currentTimeMillis();
        V022_Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序完成时间："+(end-start));
    }
    public static void testMerge(Integer [] a){
        long start = System.currentTimeMillis();
        V026_Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("归并排序完成时间："+(end-start));
    }

    public static Integer[] getArray(){
        Integer [] a = new Integer[1000000];
        for (int i = 999999; i >=0; i--) {
            a[i] = 999999-i;
        }
        return a;
    }
}
