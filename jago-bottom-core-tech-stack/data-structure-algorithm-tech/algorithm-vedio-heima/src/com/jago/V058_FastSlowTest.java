package com.jago;

/**+
 * 快慢指针
 */
public class V058_FastSlowTest {
    private static class Node<T>{
        T item;
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        //<--快慢指针获取中间值-->
//        Node<String> first = new Node<>("aa",null);
//        Node<String> second = new Node<>("bb",null);
//        Node<String> third = new Node<>("cc",null);
//        Node<String> fourth = new Node<>("dd",null);
//        Node<String> fifth = new Node<>("ee",null);
//        Node<String> six = new Node<>("ff",null);
//        Node<String> seven = new Node<>("gg",null);
//        first.next = second;
//        second.next = third;
//        third.next=fourth;
//        fourth.next= fifth;
//        fifth.next=six;
//        six.next=seven;
//        String mid = getMid(first);
//        System.out.println(mid);




//        //<--快慢指针检查环-->
//        Node<String> first = new Node<>("aa",null);
//        Node<String> second = new Node<>("bb",null);
//        Node<String> third = new Node<>("cc",null);
//        Node<String> fourth = new Node<>("dd",null);
//        Node<String> fifth = new Node<>("ee",null);
//        Node<String> six = new Node<>("ff",null);
//        Node<String> seven = new Node<>("gg",null);
//        first.next = second;
//        second.next = third;
//        third.next=fourth;
//        fourth.next= fifth;
//        fifth.next=six;
//        six.next=seven;
//        seven.next = third;
//        boolean circle = isCircle(first);
//        System.out.println(circle);






        //<--快慢指针检查环入口-->
        Node<String> first = new Node<>("aa",null);
        Node<String> second = new Node<>("bb",null);
        Node<String> third = new Node<>("cc",null);
        Node<String> fourth = new Node<>("dd",null);
        Node<String> fifth = new Node<>("ee",null);
        Node<String> six = new Node<>("ff",null);
        Node<String> seven = new Node<>("gg",null);
        first.next = second;
        second.next = third;
        third.next=fourth;
        fourth.next= fifth;
        fifth.next=six;
        six.next=seven;
        seven.next = third;
        Node entrance = getEntrance(first);
        System.out.println(entrance.item);
    }
    //通过快慢指针实现获取中间值
    public static String  getMid(Node<String> first){
        //定义两个指针，分别为快慢指针，此处指针本质还是结点
        Node<String> fast = first;
        Node<String> slow = first;
        //使用两个指针遍历链表，当快指针指向的结点没有下一个结点时结束
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //结束后返回慢指针指向的结点就是中间值
        return slow.item;
    }

    //通过快慢指针查看链表是否有环
    public static boolean isCircle(Node<String> first){
        //定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        //遍历链表，如果快慢指针指向同一个结点，证明有环
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) return true;
        }
        return false;
    }

    //通过快慢指针查看链表中环的入口元素
    public static Node getEntrance(Node<String> first){
        //定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        //遍历链表，先找到环（快慢指针相遇），准备临时指针指向链表的首结点
        //继续遍历，直到慢指针和临时指针相遇，相遇时指向的结点就是环的入口
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                temp = first;
                continue;
            }
            //让临时结点变化
            if (temp != null){
                temp = temp.next;
                //判断临时指针是否和慢指针相遇
                if (temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
    }

}
