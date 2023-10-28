package com.itheima.leetcode;
import java.util.LinkedList;
/**
  ｜  ｜
  ｜  ｜
  ｜ 1｜
  ｜ 2｜
 --------
 1+2中缀
 12+后缀
 "2","1","+","3","*"--->(2+1)*3
 -遇到数字压入栈
 -遇到运算符，就从栈弹出两个数字做运算，将结果压入栈
 -遍历结果，栈中剩下的数字就是结果
 */
public class E120reversePolandNotation {
    public int evalRPN(String[] tokens){
        LinkedList<Integer> stack = new LinkedList<>();
        for (String t:tokens){
            switch (t){
                case"+"->{ //新语法，不用写break
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a+b);
                }
                case"-"->{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a-b);
                }
                case"*"->{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a*b);
                }
                case"/"->{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(b/a);
                }
                default -> { //数字
                    stack.push(Integer.parseInt(t));
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
    }
}
