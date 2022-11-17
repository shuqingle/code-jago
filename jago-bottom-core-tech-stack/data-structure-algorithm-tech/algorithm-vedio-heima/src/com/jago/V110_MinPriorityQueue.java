package com.jago;

/**
 * 最小优先队列
 * @param <T>
 */
public class V110_MinPriorityQueue<T extends Comparable<T>>{
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public V110_MinPriorityQueue(int capacity) {
        //废除索引0
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
        //放到完全二叉树最后一位
        items[++N] = t;
        swim(N);
    }

    //删除堆中最大的元素，并返回这个最大元素
    public T delMin(){
        T min = items[1];
        exch(1,N);
        //相当于删除
        N--;
        sink(1);
        return min;
    }

    //使用上浮算法，使索引k处的元素能处在一个正确的位置
    private void swim(int k){
        //通过循环比较当前结点和父结点大小
        while (k > 1){
            if (less(k,k/2)) exch(k,k/2);
            k = k/2;
        }
    }
    //使用下沉算法，使索引k处的元素能处在一个正确的位置
    private void sink(int k ){
        //循环比较当前结点和子结点的较小值
        while (2*k <= N){
            //找到子结点较小值
            int min;
            if (2*k+1 <= N){
                //有右子结点
                if (less(2*k,2*k+1)) min = 2*k;
                else min = 2*k+1;
            }else {//没有右子结点
                min = 2*k;
            }
            //判断当前结点和子结点较小值比较
            if (less(k,min)) break;
            exch(k,min);
            k = min;
        }
    }

    public static void main(String[] args) {
        V110_MinPriorityQueue<String> queue = new V110_MinPriorityQueue<>(10);
        queue.insert("C");
        queue.insert("E");
        queue.insert("B");
        queue.insert("A");
        queue.insert("D");
        while (!queue.isEmpty()){
            System.out.print(queue.delMin()+" ");
        }
    }

}
