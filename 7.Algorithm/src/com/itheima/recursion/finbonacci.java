package com.itheima.recursion;

import java.util.Arrays;

public class finbonacci {
//    public static int f(int n){
//        if(n == 0){
//            return 0;
//        }
//        if(n == 1){
//            return 1;
//        }
//        int x = f(n-1);
//        int y = f(n-2);
//        return x+y;
//    }
    //使用Memorization(记忆法，备忘录)改进
    //Params:n——第n项
    //Return:第n项的值
    public static int fibonacci(int n){
        int[] cache = new int[n+1];
        Arrays.fill(cache,-1);//[-1,-1,-1,-1,-1,-1]，初始化
        cache[0] = 0;
        cache[1] = 1;//[0,1,-1,-1,-1,-1]
        return f(n,cache);
    }
    public static int f(int n,int[] cache){
        if(cache[n] != -1){
            return cache[n];
        }
        int x = f(n-1,cache);
        int y = f(n-2,cache);
        cache[n] =  x+y;
        return cache[n];
    }
    public static void main(String[] args) {
        int f = fibonacci(8);
        System.out.println(f);
    }
}
