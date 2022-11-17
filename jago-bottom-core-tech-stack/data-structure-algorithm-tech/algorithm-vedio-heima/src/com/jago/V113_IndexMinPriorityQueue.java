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
     * 如果要修改items中的B元素，B元素所在索引为3，那么找qp中3索引存储的元素，结果是2，我们就直知道B元素在pq数组中的位置为2
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
        return qp[k] != -1;
    }

    //最小元素关联的索引
    public int minIndex(){
        return pq[1];
    }

    //往队列中插入一个元素，并关联索引i
    public void insert(int i,T t){
        //判断i是否已经被关联，则不让插入
        if (contains(i)) return;
        //元素个数+1
        N++;
        //把数据存储到items对应的i位置处
        items[i] = t;
        //把i存储到pq中
        pq[N] = i;
        //通过qp来记录pq中的i
        qp[i] = N;
        //通过上浮完成堆的调整
        swim(N);
    }

    //删除队列中最小的元素，并返回该元素关联的索引
    public int delMin(){
        //获取最小元素关联的索引
        int minIndex = pq[1];
        //交换pq中索引1和最大索引处的元素
        exch(1,N);
        //删除qp中对应的内容
        qp[pq[N]] = -1;
        //删除pq最大索引的内容
        pq[N] = -1;
        //删除items中对应的内容
        items[minIndex] = null;
        //元素个数减一
        N--;
        //下沉调整堆
        sink(1);
        return minIndex;
    }

    //删除索引关联的元素
    public void delete(int i){
        //找到i在pq处的索引
        int k = qp[i];
        //交换pq索引k处的值和索引N处的值（最大索引）
        exch(k,N);
        //删除qp中的内容
        qp[pq[N]] = -1;
        //删除pq中的内容
        pq[N] = -1;
        //删除items中的内容
        items[k] = null;
        //元素数量减一
        N--;
        //堆的调整
        //先做上浮调整在做下沉，或者先下沉再上浮（因为不知道前后大小）
        sink(k);
        swim(k);
    }

    //把与索引i关联的元素修改为t
    public void changeItem(int i,T t){
        //修改items数组中i位置的元素为t
        items[i] = t;
        //找到i再pq中出现的位置
        int k = pq[i];
        //堆调整
        //先做上浮调整在做下沉，或者先下沉再上浮（因为不知道前后大小）
        sink(k);
        swim(k);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while (k >1){
            if (less(k,k/2)) exch(k,k/2);
            k = k/2;
        }
    }
    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        while (2*k <=N){
            //找到子结点中的较小值
            int min;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    min = 2*k;
                }else {
                    min = 2*k+1;
                }
            }else {
                min = 2*k;
            }
            //比较当前结点和较小值
            if (less(k,min)) break;
            exch(k,min);
            k = min;
        }
    }

    public static void main(String[] args) {
        V113_IndexMinPriorityQueue queue = new V113_IndexMinPriorityQueue(10);
        queue.insert(0,"C");
        queue.insert(1,"E");
        queue.insert(2,"B");
        queue.insert(3,"A");
        queue.insert(4,"D");
        queue.changeItem(2,"F");
        while (!queue.isEmpty()){
            System.out.print(queue.delMin()+" ");
        }
    }
}
