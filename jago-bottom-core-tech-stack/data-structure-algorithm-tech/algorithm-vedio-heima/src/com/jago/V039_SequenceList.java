package com.jago;

import com.sun.org.apache.bcel.internal.generic.RET;

public class V039_SequenceList <T>{
    //储存元素的数组
    private T[] eles;
    //当前线性表的长度
    private int N;
    //创建容量为capacity的SequenceList对象
    public V039_SequenceList(int capacity) {
        //初始化数组：java中不允许new T类型数组
        this.eles = (T[])new Object[capacity];
        //初始化已存储元素的个数
        this.N = 0;
    }
    //空置线性表
    public void clear(){
        this.N = 0;
    }
    //判断线性表是否为空，是则返回true,否则返回false
    public boolean isEmpty(){
        return this.N == 0;
    }
    //获取线性表中元素的个数
    public int length(){
        return this.N;
    }
    //读取并返回线性表中第i个元素的值
    public T get(int i){
        return this.eles[i];
    }
    //向线性表中添加一个元素t
    public void insert(T t){
        eles[N++] = t;
    }
    //在线性表中第i个元素之前插入一个值为t额数据元素
    public void insert(int i,T t){
        //先把i索引处的元素及其后面的元素依次向后移动一位
        for (int j = N-1; j >=i ; j--) {
            eles[j+1] = eles[j];
        }
        //再把t元素放到i位置
        eles[i] = t;
        N++;
    }
    //删除并返回线性表中第i个元素的值
    public T remove(int i){
        //记录索引i处的值
        T current = eles[i];
        //让索引i后面的元素依次向前移动一位即可
        for (int j = i; j < N-1; j++) {
            eles[j] = eles[j+1];
        }
        //元素个数减一
        N--;
        //返回i处元素
        return current;
    }
    //返回线性表中首次出现的指定的数据元素的位排序，若不存在，则返回-1
    public int indexOf(T t){
        for (int i = 0; i < this.N; i++) if (eles[i].equals(t)) return i;
        return -1;
    }

    public static void main(String[] args) {
        V039_SequenceList<String> list = new V039_SequenceList(10);
        list.insert("张三");
        list.insert("李四");
        list.insert(1,"王五");
        System.out.println(list);
    }


}
