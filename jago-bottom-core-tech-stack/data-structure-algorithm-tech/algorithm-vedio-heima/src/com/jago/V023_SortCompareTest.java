package com.jago;

public class V023_SortCompareTest {
    public static void main(String[] args) {
        Integer[] a = getArray();
//        testInsertion(a);
        testShell(a);
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

    public static Integer[] getArray(){
        Integer [] a = new Integer[100000000];
        for (int i = 99999999; i >=0; i--) {
            a[i] = 99999999-i;
        }
        return a;
    }
}
