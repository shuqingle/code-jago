package com.jago;

/**
 * 约瑟夫问题：最后两个元素就是16和31位置
 */
public class V063_JosephQuestion {
    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //解决约瑟夫问题

        //1-构建循环链表，包含41结点，分别存储1-41值
        //记录首结点
        Node<Integer> first = null;
        //记录前一个结点
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            //如果是第一个结点
            if (i==1){
                first = new Node<>(i,null);
                pre = first;
                continue;
            }
            //如果不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            //如果是最后一个结点，需要让最后一个结点的下一个结点变为first,成为循环链表
            if(i==41){
                pre.next = first;
            }
        }
        //2-需要count计数器，模拟报数
        int count = 0;
        //3-遍历循环链表
        //记录每次遍历拿到的结点默认从首结点开始
        Node<Integer> n = first;
        //记录当前结点的上一个结点
        Node<Integer> before = null;
        while (n != n.next){//最后一个结点是自己指向自己
            //模拟报数
            count++;
            //判断当前报数是不是为3
            if (count ==3){
                //如果是3，将当前结点从链表中删除，打印当前结点，重置count=0，当前结点n后移
                before.next = n.next;
                System.out.print(n.item+"-->");
                count = 0;
                n = n.next;
            }else {
                //如果不是3，让before变成当前结点,当前结点n后移
                before = n;
                n = n.next;
            }
        }
        //打印最后一个元素
        System.out.print(n.item);

    }
}
