package com.jago;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Iterator;

/**
 * 线性表-顺序表
 * @param <T>
 */
//Iterable需要指定泛型，否则foreach增强不知道具体数据类型
//foreach增强会调用iterable中的iterator方法,不实现Iterable无法实现foreach增强
public class V039_SequenceList <T> implements Iterable<T>{
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
        //扩容
        if (N == eles.length) resize(2*eles.length);
        //插入
        eles[N++] = t;
    }
    //在线性表中第i个元素之前插入一个值为t的数据元素
    public void insert(int i,T t){
        //扩容
        if (N == eles.length) resize(2*eles.length);
        //先把i索引处的元素及其后面的元素依次向后移动一位
        for (int j = N; j >=i ; j--) {
            eles[j] = eles[j-1];
        }
        //再把t元素放到i位置
        eles[i] = t;
        //元素个数+1
        N++;
    }
    //删除并返回线性表中第i个元素的值
    public T remove(int i){
        //缩容
        if (N < eles.length/4) resize(eles.length/2);
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
    //根据参数的newSize,重置eles的大小
    public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T [] temp = eles;
        //创建新数组
        eles = (T[])new Object[newSize];
        // 把原数组的数据拷贝到新数组
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }

    //实现遍历第一步：实现Iterable接口的iterator方法
    @Override
    public Iterator iterator() {
        return new SequenceListIterator();
    }
    //实现遍历第二步：声明内部类，实现Iterator接口，重写hasNext和Next方法
    private class SequenceListIterator implements Iterator{
        //当前元素
        private int cusor;
        public SequenceListIterator(){
            this.cusor = 0;
        }
        @Override
        public boolean hasNext() {
            return this.cusor < N;
        }
        @Override
        public Object next() {
            return eles[this.cusor++];
        }
    }
    public static void main(String[] args) {
        V039_SequenceList<String> list = new V039_SequenceList(10);
        list.insert("张三");
        list.insert("李四");
        list.insert(1,"王五");
        System.out.println(list);
        for(String s : list){
            System.out.println(s);
        }
    }
}
