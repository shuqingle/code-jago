package com.jago;

/**
 * 折纸问题
 */
public class V095_PageFolding {
    public static void main(String[] args) {
        //模拟折纸过程，产生树

        //中序遍历树，打印每个结点
    }

    //通过模拟对折N次纸产生树
    public static Node<String> createTree(int N){
        Node root = null;
        for (int i = 0; i < N; i++) {
            //当前是第一次对折
            if (i==0) root = new Node("down",null,null);
            //当前不是第一次对折
            //定义一个辅助队列，通过层序遍历的思想，找到叶子结点，给叶子结点添加子结点
            V072_Queue queue = new V072_Queue();
            queue.enqueue(root);

            //循环遍历队列
            while (!queue.isEmpty()){
                //从队列中弹出一个结点

                //如果有左子节点，把左子节点放到队列中
                //如果有右子节点，把右子节点放到队列中

                //如果同时没有左右子结点，证明该结点是叶子节点，只需要给该接待你添加左右子结点即可
            }

        }

        return null;
    }

    //遍历树，打印每个结点
    public static void printTree(Node<String> root){

    }


    //结点类
    private static class Node<T>{
        T item ;//存储元素
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
