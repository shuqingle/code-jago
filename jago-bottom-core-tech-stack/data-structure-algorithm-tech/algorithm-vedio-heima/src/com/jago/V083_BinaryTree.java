package com.jago;

import java.util.Queue;

/**
 * 二叉查找树
 * 本代码还有很多小问题，特殊情况处理有误，做参考
 */
public class V083_BinaryTree<Key extends Comparable<Key>,Value> {
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
        int cmp = key.compareTo(x.key);
        if (cmp > 0){
            //如果key大于x结点的键，则继续找x结点的右子树
          x.right = put(x.right,key,value);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
          x.left = put(x.left,key,value);
        }else {
            //如果key等于x结点的键，则替换x结点的value
            x.value = value;
        }
        return x;
    }

    //查询树中指定key对应的value
    public Value get(Key key){
        return get(root,key);
    }
    //查询指定的树x中查询key对应的值
    public Value get(Node x,Key key){
        //x树为null
        if (x==null) return null;
        //x树不为null
        //比较x的键和key的大小
        int cmp = key.compareTo(x.key);
        if (cmp > 0){
            //如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right,key);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left,key);
        }else {
            //如果key等于x结点的键，找到了键为key的结点，返回x结点的值
            return x.value;
        }
    }
    //删除树中的key对应的value
    public void delete(Key key){
        delete(root,key);
    }
    //删除指定树x中的key对应的value,并返回删除后的新树
    public Node delete(Node x,Key key){
        //x树为null
        if (x == null) return null;
        //x树不为null
        //比较x的键和key的大小
        int cmp = key.compareTo(x.key);
        if (cmp > 0){
            //如果key大于x结点的键，则继续找x结点的右子树
           x.right = delete(x.right,key);
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = delete(x.left,key);
        }else {
            //让元素个数减一
            N--;
            //如果key等于x结点的键，完成真正的删除结点的动作，要删除的结点就是x
            //得找到右子树中最小的结点
            //先排除特殊情况
            if (x.right == null) return x.left;//没右结点，那左结点顶替被删除元素，则返回左结点
            if (x.left == null) return x.right;//没左结点，那右结点顶替被删除元素，则返回右结点
            //左右子树都不为空的情况下才去找右子结点，进入右子结点后一直找左边直到找不到为止
            Node minNode = x.right;
            Node pre = x;
            while (minNode.left != null){
                minNode = minNode.left;
                //删除右子树中最小的结点,将最小结点的父结点的left结点置为null
                pre = minNode;
            }
            //删除右子树中最小的结点,将最小结点的父结点的left结点置为null
            pre.left = null;
//            Node n = x.right;
//            while (n.left != null){
//                if (n.left.left == null){
//                    n.left = null;
//                }else {
//                    n = n.left;
//                }
//            }
            //让x结点的左子树称为minNode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x结点的父结点指向minNode
            x = minNode;

        }
        return x;
    }

    //找出整个树中最小的键
    public Key min(){
        if (root == null) return null;
        return min(root).key;

    }
    //找出指定树中最小键所在的结点
    private Node min(Node x){
        //需要判断x还有没有左子结点，如果有继续找左子节点，如果没有，则x就是最小键所在的节点
        if (x.left != null) return min(x.left);
        else return x;
    }

    //找出整个树中最大的键
    public Key max(){
        if (root == null) return null;
        return max(root).key;
    }

    //找出指定树中最大键的结点
    private Node max(Node x){
        if (x.right != null) return max(x.right);
        else return x;
    }

    //---------------------前序遍历start---------------------//
    //使用前序遍历获取整个树所有的键
    public V072_Queue<Key> preErgodic(){
        V072_Queue<Key> keys = new V072_Queue<Key>() ;
        preErgodic(root,keys);
        return keys;
    }
    //获取指定树x所有键，并放到keys队列中
    private void preErgodic(Node x,V072_Queue<Key> keys){
        if (x == null) return;
        //把x结点的key放入到keys中
        keys.enqueue(x.key);
        //递归遍历x结点的左子树
        if (x.left != null) preErgodic(x.left,keys);
        //递归遍历x结点的右子树
        if (x.right != null) preErgodic(x.right,keys);
    }
    //---------------------前序遍历end---------------------//



    //---------------------中序遍历start---------------------//
    //使用中序遍历获取树中所有键
    public V072_Queue<Key> midErgodic(){
        V072_Queue<Key> keys = new V072_Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    //使用中序遍历数去树x中所有键，并存放到keys中
    public void midErgodic(Node x,V072_Queue<Key> keys){
        if (x == null) return;
        //递归遍历x结点的左子树，把左子树键放到keys中
        if (x.left != null) midErgodic(x.left,keys);
        //把x结点的key放入到keys中
        keys.enqueue(x.key);
        //递归遍历x结点的右子树，把右子树键放到keys中
        if (x.right != null) midErgodic(x.right,keys);
    }
    //---------------------中序遍历end---------------------//


    //---------------------后序遍历start---------------------//
    //使用后序遍历获取树中所有键
    public V072_Queue<Key> afterErgodic(){
        V072_Queue<Key> keys = new V072_Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    //使用中序遍历数去树x中所有键，并存放到keys中
    public void afterErgodic(Node x,V072_Queue<Key> keys){
        if (x == null) return;
        //递归遍历x结点的左子树，把左子树键放到keys中
        if (x.left != null) afterErgodic(x.left,keys);
        //递归遍历x结点的右子树，把右子树键放到keys中
        if (x.right != null) afterErgodic(x.right,keys);
        //把x结点的key放入到keys中
        keys.enqueue(x.key);
    }
    //---------------------后序遍历end---------------------//


    //---------------------层序遍历start---------------------//
    public V072_Queue<Key> layerErgodic(){
        //定义2个队列，分别存储树中的键和树中的结点
        V072_Queue<Key> keys = new V072_Queue<>();
        V072_Queue<Node> nodes = new V072_Queue<>();
        //默认往队列中放入根节点
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            //从队列中弹出一个结点，把key放入到keys中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            //判断当前结点还有没有左子结点，如果有放入nodes
            if (n.left != null) nodes.enqueue(n.left);
            //判断当前结点还有没有右子结点，如果有放入nodes
            if (n.right != null) nodes.enqueue(n.right);
        }
        return keys;
    }
    //---------------------层序遍历end---------------------//
    //计算树的最大深度
    public int maxDepth(){
        return -1;
    }
    //计算指定树x的最大深度
    private int maxDepth(Node x){
        return -1;
    }


    public static void main(String[] args) {
//        V083_BinaryTree binaryTree = new V083_BinaryTree();
//        binaryTree.put("3","33");
//        binaryTree.put("2","22");
//        binaryTree.put("4","44");
//        binaryTree.put("5","55");
//        binaryTree.put("6","66");
//        binaryTree.put("7","77");
//        binaryTree.put("1","11");
//                binaryTree.put("1","11");
//        binaryTree.put("2","22");
//        binaryTree.put("3","3");
//        System.out.println("元素的个数"+binaryTree.size());
//        System.out.println(binaryTree.get("2"));
//        binaryTree.delete("2");
//        System.out.println("元素的个数"+binaryTree.size());
//        System.out.println(binaryTree.get("2"));

        V083_BinaryTree binaryTree = new V083_BinaryTree();
        binaryTree.put("E","5");
        binaryTree.put("B","2");
        binaryTree.put("G","7");
        binaryTree.put("A","1");
        binaryTree.put("D","4");
        binaryTree.put("F","6");
        binaryTree.put("H","8");
        binaryTree.put("C","3");
        //前序遍历测试
//        V072_Queue queue = binaryTree.preErgodic();
        //中序遍历测试
//        V072_Queue queue = binaryTree.midErgodic();
        //后序遍历测试
//        V072_Queue queue = binaryTree.afterErgodic();
        //层序遍历测试
        V072_Queue queue = binaryTree.layerErgodic();
        //中序遍历测试
        queue.forEach(x->{
            System.out.println(x);
        });
    }

}
