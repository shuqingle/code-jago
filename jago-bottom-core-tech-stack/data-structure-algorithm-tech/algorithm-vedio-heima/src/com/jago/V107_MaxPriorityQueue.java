package com.jago;

import java.util.Queue;

/**
 * 最大优先队列
 * @param <T>
 */
public class V107_MaxPriorityQueue<T extends Comparable<T>>{
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public V107_MaxPriorityQueue(int capacity) {
        this.items = (T[])new Comparable[capacity+1];
        this.N = 0;
    }

    //获取队列中元素的个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引的值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //删除堆中最大的元素，并返回这个最大元素
    public T delMax(){
        T max = items[1];
        exch(1,N);
        N--;
        sink(1);
        return max;
    }

    //使用上浮算法，使索引k处的元素能处在一个正确的位置
    private void swim(int k){
        while (k > 1){
            if (less(k/2,k)) exch(k/2,k);
            k = k/2;
        }
    }
    //使用下沉算法，使索引k处的元素能处在一个正确的位置
    private void sink(int k ){
        while (2*k <= N){
            int max;
            if (2*k+1 <= N){
                //有右子结点
                if (less(2*k,2*k+1)) max = 2*k+1;
                else max = 2*k;
            }else {
                max = 2*k;
            }
            if (!less(k,max)) break;
            exch(k,max);
            k = max;
        }
    }

    public static void main(String[] args) {
        V107_MaxPriorityQueue<String> queue = new V107_MaxPriorityQueue<>(10);
        queue.insert("C");
        queue.insert("B");
        queue.insert("A");
        queue.insert("D");
        queue.insert("E");
        queue.insert("G");
        queue.insert("F");
        while (!queue.isEmpty()){
            System.out.print(queue.delMax()+" ");
        }
    }

}
