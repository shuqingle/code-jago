package com.jago;

public class V107_MaxPriorityQueue<T extends Comparable<T>>{
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public V107_MaxPriorityQueue(int capacity) {
        this.items = (T[])new Comparable[capacity+1];
        
    }

    //获取队列中元素的个数
    public int size(){
        return -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return false;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return false;
    }

    //交换堆中i索引和j索引的值
    private void exch(int i,int j){

    }

    //往堆中插入一个元素
    public void insert(T t){

    }

    //删除堆中最大的元素，并返回这个最大元素
    public T delMax(){
        return null;
    }

    //使用上浮算法，使索引k处的元素能处在一个正确的位置
    private void swim(int k){

    }
    //使用下沉算法，使索引k处的元素能处在一个正确的位置
    private void sink(int k ){

    }

}
