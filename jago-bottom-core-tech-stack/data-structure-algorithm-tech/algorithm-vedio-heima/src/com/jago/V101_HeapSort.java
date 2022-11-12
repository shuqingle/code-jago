package com.jago;

/**
 * 堆排序
 */
public class V101_HeapSort {
    //判断堆Heap中索引i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap,int i, int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    //交换Heap堆中i索引和j索引处的值
    private static void exch(Comparable[] heap,int i, int j){
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    //根据原数组source，构造出堆Heap
    private static void createHeap(Comparable[] source,Comparable[] heap){
        
    }

    //对source数组中的数据从小到大排序
    public static void sort(Comparable[] source){

    }

    //在heap堆中，对target处的元素做下沉，范围是0-range
    private static void sink(Comparable[] heap,int target,int range){

    }
}
