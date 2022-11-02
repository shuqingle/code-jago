package com.jago;

/**
 * 逆波兰表达式
 */
public class V070_ReversePolishNotationTest {
    public static void main(String[] args) {
        //中缀表达式 3*(17-15)+18/6的逆逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果：" + result);
    }

    //根据逆波兰表达式数组表示方式计算逆波兰表达式的计算结果
    private static int calculate(String[] notation) {
        //需要定义一个栈，存储操作数
        V066_Stack<Integer> oprs = new V066_Stack<>();
        //从左往右遍历逆波兰表达式数组，得到元素
        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];
            //判断当前元素是运算符还是操作数
            //如果是运算符，需要从栈中弹出两个操作数，完成运算，将运算完的结果压入栈中
            Integer o1;
            Integer o2;
            int result;
            switch (curr) {
                case "+":
                    o1 = oprs.pop();
                    o2 = oprs.pop();
                    result = o2 + o1;
                    oprs.push(result);
                    break;
                case "-":
                    o1 = oprs.pop();
                    o2 = oprs.pop();
                    //操作输入入栈顺序和取出的数据相反1，o2是先进的数
                    result = o2 - o1;
                    oprs.push(result);
                    break;
                case "*":
                    o1 = oprs.pop();
                    o2 = oprs.pop();
                    result = o2 * o1;
                    oprs.push(result);
                    break;
                case "/":
                    o1 = oprs.pop();
                    o2 = oprs.pop();
                    result = o2 / o1;
                    oprs.push(result);
                    break;
                default:
                    //如果是操作数，将操作数栈中
                    oprs.push(Integer.parseInt(curr));
                    break;
            }
        }
        //得到栈中最后一个元素就是逆波兰表达式的结果
        int result = oprs.pop();
        return result;
    }
}
