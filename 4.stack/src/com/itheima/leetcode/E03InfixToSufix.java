package com.itheima.leetcode;

import java.util.LinkedList;

/**
 ｜  ｜
 ｜ -｜
 ｜ +｜
 --------
 a+b --------> a b +
 a+b-c-------> a b + c -
 a*b+c-------> a b * c +
 a+b*c------->a b c * +
 a+b*c-d----->abc*+d-
 (a+b)*c----->ab+c*
 (a+b*c-d)*e
 -遇到非i运算符 直接拼串
 1-遇到 + - * /
     -它的优先级比栈顶运算符高，入栈
     -否则把栈里优先级>=它的都出栈，它再入栈
 -遍历完成，栈里剩余运算符依次出栈
 2-带（）
     -左括号直接入栈，左括号优先设置位0
     -右括号就把栈里到左括号为止的运算符全部出栈
 */
public class E03InfixToSufix {
    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("a*(b+c)"));
    }
    //定义运算符优先级的方法
    static int priority(char c){
        return switch(c){
            case '*','/'-> 2;
            case '+','-'-> 1;
            case '('-> 0;
            default -> throw new IllegalArgumentException("不合法运算符："+c);

        };
    }
    static String infixToSuffix(String exp){
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(exp.length());
        for (int i = 0; i <exp.length() ; i++) {
            char c = exp.charAt(i);
            switch (c){
                case '+','-','*','/' ->{
                    if(stack.isEmpty()){
                        stack.push(c);
                    }
                    else{
                        if(priority(c)>priority(stack.peek())){
                            stack.push(c);
                        }else{
                            while(!stack.isEmpty()&&priority(stack.peek())>=priority(c)){
                                sb.append(stack.poll());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '('->{
                    stack.push(c);
                }
                case ')'->{
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> {
                    sb.append(c);
                }
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
