package com.jago;

/**
 * 折纸问题
 * 折痕数量 2^N-1
 */
public class V095_PageFolding {
    public static void main(String[] args) {
        //模拟折纸过程，产生树
        Node<String> tree = createTree(3);
        //中序遍历树，打印每个结点
        printTree(tree);
    }
    //通过模拟对折N次纸产生树
    public static Node<String> createTree(int N){
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            //当前是第一次对折
            if (i==0) {
                root = new Node("down",null,null);
                continue;
            }
            //当前不是第一次对折
            //定义一个辅助队列，通过层序遍历的思想，找到叶子结点，给叶子结点添加子结点
            V072_Queue<Node> queue = new V072_Queue();
            queue.enqueue(root);
            //循环遍历队列
            while (!queue.isEmpty()){
                //从队列中弹出一个结点
                Node<String>  temp = queue.dequeue();
                //如果有左子节点，把左子节点放到队列中
                if (temp.left != null) queue.enqueue(temp.left);
                //如果有右子节点，把右子节点放到队列中
                if (temp.right != null) queue.enqueue(temp.right);
                //如果同时没有左右子结点，证明该结点是叶子节点，只需要给该接待你添加左右子结点即可
                if (temp.left == null && temp.right == null) {
                    temp.left = new Node<String> ("down",null,null);
                    temp.right = new Node<String> ("up",null,null);
                }
            }
        }
        return root;
    }

    //遍历树，打印每个结点
    public static void printTree(Node<String> root){
        //使用中序遍历完成
        if (root == null) return;
        //打印左子树的每个结点
        if (root.left != null) printTree(root.left);
        //打印当前结点
        System.out.print(root.item+" ");
        //打印右子树的每个结点
        if (root.right != null) printTree(root.right);
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
