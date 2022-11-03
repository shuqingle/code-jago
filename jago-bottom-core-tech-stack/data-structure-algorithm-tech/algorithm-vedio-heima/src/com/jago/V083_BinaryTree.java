package com.jago;

/**
 * 二叉查找树
 */
public class V083_BinaryTree<Key,Value> {
    private class Node{
        //存储键
        public Key key;
        //存储值
        public Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    //记录根结点
    private Node root;
    //记录树的元素个数
    private int N;

    //获取树中元素的个数
    public int size(){
        return N;
    }

    //向树中添加元素key-value
    public void put(Key key,Value value){
        //root可以代表整个树
       root = put(root,key,value);
    }

    //向指定的树x中添加key-value,并返回添加元素后的树(x为子树)
    public Node put(Node x,Key key,Value value){
        //如果x子树为空
        if (x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果x子树不为空
        //比较x结点键和目标key的大小：
        //如果key小于x结点的键，则继续找x结点的左子树
        //如果key大于x结点的键，则继续找x结点的右子树
        //如果key等于x结点的键，则替换x结点的value
        return null;
    }

    //查询树中指定key对应的value
    public Value get(Key key){
        return null;
    }

    //查询指定的树x中查询key对应的值
    public Value get(Node x,Key key){
        return null;
    }

    //删除树中的key对应的value
    public void delete(Key key){

    }

    //删除指定树x中的key对应的value,并返回删除后的新树
    public Node delete(Node x,Key key){
        return null;
    }


}
