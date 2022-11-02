package com.jago;

/**
 * 有序符号表
 */
public class V077_OrderSymbolTable<Key extends Comparable<Key>,Value> {
    private class Node{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;
    public V077_OrderSymbolTable() {
        this.head = new Node(null,null,null);
        this.N = 0;
    }
    //获取符号表中键值对的个数
    public int size(){
        return N;
    }
    //往符号表中插入键值对，需要考虑键的顺序
    public void put(Key key,Value value){
        //定义两个node变量，分别记录当前节点和当前结点的上一个结点
        Node curr = head.next;
        Node pre = head;
        while (curr != null && key.compareTo(curr.key)>0){
            //变化当前结点和前一个结点
            pre = curr;
            curr = curr.next;
        }
        //如果当前结点curr的key和目标key一样，则替换
        if (curr != null && key.compareTo(curr.key) == 0){
            curr.value = value;
        }
        //如果当前结点和key和目标key不一样，则插入新结点插入到curr之前即可
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
        //元素的个数加1
        N++;
    }
    //删除符号表中键为key的键值对
    public void delete(Key key){
        //找到键的key的结点，把该结点从链表中删除
        Node n = head;
        while (n.next != null){
           //判断n结点的下一个结点的键是否为key,如果是则删除该结点
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            //如果不等于key，则继续往下走
            n = n.next;
        }
    }
    //从符号表获取key对应的值
    public Value get(Key key){
        //找到key所在的结点
        Node n = head;
        while (n.next != null){
            n = n.next;
            if (n.key.equals(key)) return n.value;
        }
        return null;
    }
    public static void main(String[] args) {
        V077_OrderSymbolTable<Integer,String> symbolTable = new V077_OrderSymbolTable();
        symbolTable.put(1,"1");
        symbolTable.put(2,"2");
        symbolTable.put(4,"4");
        symbolTable.put(3,"3");
        System.out.println(symbolTable);

    }
}
