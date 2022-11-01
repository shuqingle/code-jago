package com.jago;

/**
 * 括号成对检查
 */
public class V068_BracketMatch {
    public static void main(String[] args) {
        String str = "(上海(长安)()";
        System.out.println(str+" 字符串存在成对括号："+isMatch(str));
    }
    public static boolean isMatch(String str){
        //创建栈对象，用来存储左括号
        V066_Stack<String> stack = new V066_Stack<>();
        //从左往右遍历字符串
        for (int i = 0; i < str.length(); i++) {
            String currChar = str.charAt(i)+"";
            //判断当前字符是否为左括号，如果是则字符放入栈中
            if (currChar.equals("(")) stack.push(currChar);
                //继续判断当前是否为右括号，如果是，则弹出一个左括号，并判断弹出的结果是否为null
            else if (currChar.equals(")")){
                String pop = stack.pop();
                if (pop == null){
                    //如果是null，则证明没有匹配的的左括号，如果不为null，则证明有匹配的左括号
                    return false;
                }
            }
        }
        //遍历完成后判断栈中是否有剩余的左括号，如果有则表示括号不匹配
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
