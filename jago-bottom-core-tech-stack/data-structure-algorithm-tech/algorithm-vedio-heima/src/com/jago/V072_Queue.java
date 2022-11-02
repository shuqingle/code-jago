package com.jago;

import java.util.Iterator;

/**
 * 线性表-队列
 */
public class V072_Queue<T> implements Iterable<T> {


    //结点内部类
    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    //记录首结点
    private Node head;
    //记录尾结点
    private Node last;
    //记录队列中元素的个数
    private int N;
    //构造方法
    public V072_Queue() {
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //返回队列中元素的个数
    public int size(){
        return N;
    }
    //向队列中插入元素
    public void enqueue(T t){
        if (last == null){
            //当前尾结点last为null
            last = new Node(t,null);
            head.next = last;
        }else {
            //当前尾结点last不为null
            Node oldLast = last;
            last = new Node(t,null);
            oldLast.next = last;
        }
        //元素个数+1
        N++;
    }
    //从队列中拿出一个元素
    public T dequeue(){
        //判断空队列
        if (isEmpty()) return null;
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        //出队列是删除元素，如果队列元素被删除完了，需要重置last
        if (isEmpty()) last = null;
        return oldFirst.item;
    }
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
    private class QueueIterator implements Iterator<T>{
        private Node n;

        public QueueIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }

    public static void main(String[] args) {
        V072_Queue<String> queue = new V072_Queue();
        queue.enqueue("aa");
        queue.enqueue("bb");
        queue.enqueue("cc");
        queue.forEach(x->{
            System.out.println(x);
        });
        queue.dequeue();
        queue.dequeue();
        for (String o : queue) {
            System.out.println(o);
        }
    }
}
