package com.jago;

/**
 * 无序符号表
 */
public class V075_NonOrderSymbolTable<Key,Value> {
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

    public V075_NonOrderSymbolTable() {
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    //获取符号表中键值对的个数
    public int size(){
        return N;
    }
    //往符号表中插入键值对
    public void put(Key key,Value value){
        //符号表中已经存在了键为key的键值对，只需要找到该结点，替换值为value即可
        Node n = head;
        while (n.next != null){
            //变换n
            n = n.next;
            //判断n结点存储的键是否为key，如果是则替换n结点的值
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        //如果符号表中不存在键为key的键值对，需要创建新的结点，保存要插入的键值对，把新节点插入链表的头部head.next=新节点
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next = oldFirst;
        head.next = newNode;
        //元素个数加1
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
        V075_NonOrderSymbolTable<String,String> symbolTable = new V075_NonOrderSymbolTable();
        symbolTable.put("aaa","111");
        symbolTable.put("bbb","222");
        symbolTable.put("aaa","111");
        System.out.println(symbolTable.get("aaa"));
        symbolTable.delete("aaa");
        System.out.println(symbolTable.get("aaa"));
        System.out.println(symbolTable.size());
    }
}
