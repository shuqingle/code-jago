package com.jago;

/**
 * 堆的实现
 * @param <T>
 */
public class V097_Heap<T extends Comparable<T>>{
    //存储堆中元素的数组
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public V097_Heap(int capacity){
        this.items = (T[]) new Comparable[capacity+1];//因为废弃了0索引，所以数组总长度capacity+1，补一个
        this.N = 0;
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
        items[++N] = t;//废弃0索引，方便后续操作
        //使用上浮算法重新调整元素的位置
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    //把当前索引的元素一直和父结点比较，如果比父结点大，则和父结点交换位置，直到父结点大于该元素
    private void swim(int k){
        //通过循环，不断的比较当前结点的值和其父结点的值，如果发现父结点的值比当前结点的值小，则交换位置
        while (k>1){
            //比较当前结点和其父结点
            if (less(k/2,k)){
                exch(k/2,k);
            }
            k = k/2;
        }
    }

    //删除堆中最大的元素，并返回这个最大元素
    public T delMax(){
        //最大结点就是根节点
        T max = items[1];
        //交换最大索引元素和最大索引处的元素，让完全二叉树中最右侧的元素变为临时结点
        exch(1,N);
        //最大索引处的元素删除掉
        items[N] = null;
        //元素个数减一
        N--;
        //通过下沉算法调整堆，让堆重新有序
        sink(1);
        return max;
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //通过循环不断的对比当前k结点和其左子结点2k及右子结点2k+1处中的较大值的元素大小，如果当前结点小，则需要交换
        while (2*k <= N){
            //获取当前结点的子结点较大结点
            int max;//记录较大结点所在的索引
            if (2*k+1 <= N){
                if (less(2*k,2*k+1)){
                    max = 2*k+1;//右结点
                }else max = 2*k;//左结点
            }else {
                max = 2*k;//无右节点，取左结点
            }
            //比较当前结点和较大结点的值
            if (!less(k,max)) break;
            //交换k索引处的值和max索引的值
            exch(k,max);
            //变换k和max的值
            k = max;
        }
    }

    public static void main(String[] args) {
        V097_Heap<String> heap = new V097_Heap(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("D");
        heap.insert("E");
        heap.insert("C");
        String result = null;
        while ((result = heap.delMax()) != null){
            System.out.print(result+" ");
        }
    }

}
