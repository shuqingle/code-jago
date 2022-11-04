package com.jago;

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

    public static void main(String[] args) {
        V083_BinaryTree binaryTree = new V083_BinaryTree();
//        binaryTree.put("3","33");
//        binaryTree.put("2","22");
//        binaryTree.put("4","44");
//        binaryTree.put("5","55");
//        binaryTree.put("6","66");
//        binaryTree.put("7","77");
//        binaryTree.put("1","11");
                binaryTree.put("1","11");
        binaryTree.put("2","22");
        binaryTree.put("3","3");
        System.out.println("元素的个数"+binaryTree.size());
        System.out.println(binaryTree.get("2"));
        binaryTree.delete("2");
        System.out.println("元素的个数"+binaryTree.size());
        System.out.println(binaryTree.get("2"));
    }

}
