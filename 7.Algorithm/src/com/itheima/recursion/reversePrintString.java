package com.itheima.recursion;
//递归反向打印字符串
public class reversePrintString {
    public static void r(int n,String str){
        if(n == str.length()){
            return;
        }
        r(n+1,str);
        System.out.println(str.charAt(n));

    }
    public static void main(String[] args) {
        r(0,"abcde");
    }
}
