package com.jago;

import java.util.Iterator;
import java.util.Stack;

/**
 * 线性表-栈
 */
public class V066_Stack<T>implements Iterable<T>{
    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    //记录首部结点
    private Node head;
    //栈中元素的个数
    private int N;
    public V066_Stack() {
        this.head = new Node(null,null);
        N = 0;
    }
    //判断栈中元素的个数是否为0
    public boolean isEmpty(){
        return N==0;
    }
    //获取栈中元素的个数
    public int size(){
        return N;
    }
    //把元素压入栈
    public void push(T t){
        //先进后出
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        //创建新节点
        Node newNode = new Node(t,null);
        //让首结点指向新节点
        head.next = newNode;
        //让新节点指向原来的第一个结点
        newNode.next = oldFirst;
        //元素个数+1即可
        N++;
    }
    //弹出栈顶元素
    public T pop(){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        if (oldFirst == null) return null;
        //让首结点指向原来的第一个结点的下一个节点
        head.next = oldFirst.next;
        //让元素个数减一
        N--;
        return oldFirst.item;
    }
    @Override
    public Iterator iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<T>{
        //记录当前结点
        private  Node n;
        public StackIterator() {
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
        V066_Stack<String> s = new V066_Stack<>();
        s.push("1");
        s.push("2");
        s.push("3");

        for (String v:s) {
            System.out.println(v);
        }
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
