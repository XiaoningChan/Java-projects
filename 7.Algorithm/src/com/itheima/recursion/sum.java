package com.itheima.recursion;
//递归求和n + n-1 + n-2 +...+ 1
public class sum {
    //f(n) = f(n-1) + n
    public static long sum(long n){
        if(n == 1){
            return 1;
        }
        return sum(n-1)+n;
    }
    public static void main(String[] args) {
        System.out.println(sum(100000)); //报错：爆栈了！
    }
}
