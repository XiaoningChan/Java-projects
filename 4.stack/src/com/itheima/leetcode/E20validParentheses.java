package com.itheima.leetcode;

import com.itheima.stack.ArrayStack;
/**
 （   [    {
 底 - 栈 - 顶
 )   ]    }
 */
//Leetcode 20
public class E20validParentheses {
    public boolean isvalid(String s){
        ArrayStack<Character> stack = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else{  //遇到右括号
                if(!stack.isEmpty() && c == stack.peek()){ //!stack.isEmpty()是考虑遍历到的第一个字读不能是右括号
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();//循环所有右括号与栈比对完毕后若栈为空则为有效字符串，否则不是
    }
    /**
     遇到左括号，把要匹配的右括号放入栈顶
     遇到右括号，把它与栈顶元素比对
     若想等，栈顶元素弹出，继续比对下一组
     若不等，无效括号直接返回false
     */
    public static void main(String[] args) {
        E20validParentheses s = new E20validParentheses();
        System.out.println(s.isvalid("([{}])"));
        System.out.println(s.isvalid("()[]{}"));
        System.out.println(s.isvalid("()"));
        System.out.println(s.isvalid("[)"));
        System.out.println(s.isvalid(")("));
        System.out.println(s.isvalid("([)]"));
        System.out.println(s.isvalid("([]"));
        System.out.println(s.isvalid("("));
        System.out.println(s.isvalid("]"));
    }
}
