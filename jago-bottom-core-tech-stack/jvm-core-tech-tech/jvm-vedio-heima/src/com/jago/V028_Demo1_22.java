package com.jago;

public class V028_Demo1_22 {
    public static void main(String[] args) {
        //常量池中的信息，都会被加载到运行时常量池中，这时a,b,ab都是常量池中的符号，还没有变为java字符串对象
        //准备好stringTable{}的哈希表(hashTable结构)空间,不能扩容
        //ldc #2 会把a符号变为“a”的字符串对象，以“a”为key去stringTable中找，如果找不到，则将"a"为key，value为字符串a的对象放入stringTable
        //ldc #3 会把a符号变为“b”的字符串对象，以“b”为key去stringTable中找，如果找不到，则将"b"为key，value为字符串a的对象放入stringTable
        //ldc #4 会把a符号变为“ab”的字符串对象，以“ab”为key去stringTable中找，如果找不到，则将"ab"为key，value为字符串a的对象放入stringTable
        //上述行为为懒加载行为，结果：stringTable{"a","b","ab"}

        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";//s3在StringTable中
//        //直接去常量池中找"ab"
//        String s4 = "a" + "b";//javac在编译期间优化，结果已经在编译期间确定为ab
//        System.out.println(s3 == s4);//true
        //s4是new出来的，所以在堆中
        //变量拼接，表示引用值有可能修改，结果不能确定，所以在运行期间用StringBuilder动态拼接
        String s4 = s1 + s2;//new StringBuilder().append("a").append("b").toString();,而toString就是new String("ab")
        //jdk 8 是 false;
        //jdk 17没用StringBuilder,所以是true
        System.out.println(s3==s4);
    }
}
