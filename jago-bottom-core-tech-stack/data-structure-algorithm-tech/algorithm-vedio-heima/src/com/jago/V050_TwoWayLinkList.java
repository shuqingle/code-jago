package com.jago;

import java.util.Iterator;

/**
 * 双向链表-双向链表-单向双向链表
 * @param <T>
 */
public class V050_TwoWayLinkList<T> implements Iterable<T> {
    //成员内部类：结点类
    private class Node{
        //存储数据
        T item;
        //存储上个结点
        Node pre;
        //存储下个结点
        Node next;
        public Node(T item, Node pre,Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
    //记录头结点
    private Node head;
    //记录尾结点
    private Node last;
    //记录双向链表长度
    private int N;
    //构造方法
    public V050_TwoWayLinkList() {
        //初始化头结点
        this.head = new Node(null,null,null);
        //初始化尾结点
        this.last = null;
        //初始化元素个数
        this.N = 0;
    }
    //空置双向链表
    public void clear(){
        this.head.next = null;
        //头结点本身无数据存储，默认为null，pre也是null，可以不用清空
        this.last = null;
        this.N = 0;
    }
    //判断双向链表是否为空，是则返回true,否则返回false
    public boolean isEmpty(){
        return this.N == 0;
    }
    //获取双向链表中元素的个数
    public int length(){
        return this.N;
    }
    //获取双向链表第一个元素
    public T getFirst(){
        if (isEmpty()) return null;
        return head.next.item;
    }
    //获取双向链表最后一个元素
    public T getLast(){
        return last.item;
    }

    //向双向链表中添加一个元素t
    public void insert(T t){
        if (isEmpty()){//如果双向链表为空
            //创建新节点
            Node newNode = new Node(t,head,null);
            //让新节点成为尾结点
            this.last = newNode;
            //让头结点指向尾结点
            this.head.next = last;
        }else {//如果双向链表不为空
            //记录之前的尾结点
            Node oldLastNode = last;
            //创建新节点
            Node newNode = new Node(t,oldLastNode,null);
            //让当前的尾结点指向新节点
            this.last.next = newNode;
            //让新节点成为尾结点
            last = newNode;
        }
        //元素的个数+1
        this.N++;
    }

    //在双向链表中第i个元素之前插入一个值为t的数据元素
    public void insert(int i,T t){
        //找到i位置的前一个结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点
        Node newNode = new Node(t,pre,curr);
        //让i位置的前一个位置的下一个结点变为新节点
        pre.next = newNode;
        //让i位置的前一个结点变为新节点
        curr.pre = newNode;
        //元素的个数+1
        this.N++;
    }
    //读取并返回双向链表中第i个元素的值
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
    //返回双向链表中首次出现的指定的数据元素的位排序，若不存在，则返回-1
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
    //删除并返回双向链表中第i个元素的值
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
    
    @Override
    public Iterator<T> iterator() {
        return new TwoWayLinkListIterator();
    }
    private class TwoWayLinkListIterator implements Iterator<T>{
        private Node n;
        public TwoWayLinkListIterator() {
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
        V050_TwoWayLinkList<String> list = new V050_TwoWayLinkList();
        list.insert("张三");
        list.insert("李四");
        list.insert(1,"王五");
        System.out.println(list);
        for(String s : list){
            System.out.println(s);
        }
    }


}
