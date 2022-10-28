package com.jago;

import java.util.Iterator;

/**
 * 单向链表-单向链表-单向单向链表
 * @param <T>
 */
public class V046_OneWayLinkList<T> implements Iterable<T> {
    //成员内部类：结点类
    private class Node{
        T item;
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    //记录头节点
    private Node head;
    //记录单向链表长度
    private int N;
    //构造方法
    public V046_OneWayLinkList() {
        //初始化头结点
        this.head = new Node(null,null);
        //初始化元素个数
        this.N = 0;
    }
    //空置单向链表
    public void clear(){
        if (this.head != null) this.head.next = null;
        this.N = 0;
    }
    //判断单向链表是否为空，是则返回true,否则返回false
    public boolean isEmpty(){
        return this.N == 0;
    }
    //获取单向链表中元素的个数
    public int length(){
        return this.N;
    }
    //读取并返回单向链表中第i个元素的值
    public T get(int i){
        //通过循环，从头结点开始往后找，依次找i次，就可以找到对应的元素
        Node n = this.head.next;
        for (int j = 0; j < i; j++) {
            if (n != null) n = n.next;
            else break;
        }
        if (n == null) return null;
        else return n.item;
    }
    //向单向链表中添加一个元素t
    public void insert(T t){
        //找到当前最后一个结点
        Node n = this.head;
        while (n.next != null) n = n.next;
        //创建新结点，保存元素t
        Node newNode = new Node(t,null);
        //让当前最后一个结点指向新结点
        n.next = newNode;
        //元素的个数+1
        this.N++;
    }
    //在单向链表中第i个元素之前插入一个值为t的数据元素
    public void insert(int i,T t){
        //找到i位置前一个结点
        Node pre = this.head;
        //找到i位置的结点
        for (int j = 0; j < i-1; j++) {
            pre = pre.next;
        }
        //当前结点
        Node curr = pre.next;
        //创建新节点，新结点需要指向原来i位置的结点
        Node newNode = new Node(t,curr);
        //原来i位置的前一个结点指向新结点即可
        pre.next = newNode;
        //元素的个数+1
        this.N++;
    }
    //删除并返回单向链表中第i个元素的值
    public T remove(int i){
        //找到i位置前一个结点
        Node pre = this.head;
        //找到i位置的结点
        for (int j = 0; j < i-1; j++) {
            pre = pre.next;
        }
        //当前结点
        Node curr = pre.next;
        //前一个结点指向下一个结点
        pre.next = curr.next;
        this.N--;
        return curr.item;
    }
    //返回单向链表中首次出现的指定的数据元素的位排序，若不存在，则返回-1
    public int indexOf(T t){
        //从头节点开始，依次找到每一个结点，取出item,和t比较，如果相同，就找到了
        Node n = this.head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public Iterator<T> iterator() {
        return new OneWayLinkListIterator();
    }
    private class OneWayLinkListIterator implements Iterator<T>{
        private Node n;
        public OneWayLinkListIterator() {
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
        V046_OneWayLinkList<String> list = new V046_OneWayLinkList();
        list.insert("张三");
        list.insert("李四");
        list.insert(1,"王五");
        System.out.println(list);
        for(String s : list){
            System.out.println(s);
        }
    }


}
