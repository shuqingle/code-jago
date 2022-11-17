package com.jago;

/**
 * 索引优先队列
 */
public class V113_IndexMinPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //保存每个元素在items数组中的索引，pq数组需要堆有序
    private int [] pq;
    //保存qp的逆序，pq的值作为索引，pq的索引作为值
    private int[] qp;
    //记录堆中元素的个数
    private int N;

    /**         1   2   3   4   5
     * items    C   E   B   A   D
     * pq       A   B   C   E   D
     *          4   3   1   2   5
     * qp       3   4   2   1   5
     * 如果要修改items中的B元素，B元素所在索引为3，那么找qp中3索引存储的元素，结果是2，我们就直到B元素在pq数组中的位置为2
     *
     * @param capacity
     */

    public V113_IndexMinPriorityQueue(int capacity) {
        this.items = (T[])new Comparable[capacity+1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        this.N = 0;
        //默认情况下队列中没有存储任何元素，让qp中元素都为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i]=-1;
        }
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
        //pq存储的是数据在items中的索引
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i,int j){
        //先交换pq中的数据
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        //再交换qp中的数据
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //判断k对应的元素是否存在
    public boolean contains(int k){
        return false;
    }

    //最小元素关联的索引
    public int minIndex(){
        return -1;
    }

    //往队列中插入一个元素，并关联索引i
    public void insert(int i,T t){

    }

    //删除队列中最小的元素，并返回该元素关联的索引



}
