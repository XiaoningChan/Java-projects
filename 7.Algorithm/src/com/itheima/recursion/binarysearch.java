package com.itheima.recursion;

public class binarysearch {
    public static int search(int[] a,int target){
        return f(a,target,0,a.length-1);
    }
    private static int f(int[] a,int target,int i,int j){
        if(i>j){
            return -1;
        }
        int m = (i+j)>>>1;
        if (target < a[m]) {
            return f(a,target,i,m-1);
        }else if(target > a[m]){
            return f(a,target,m+1,j);
        }else{
            return m;
        }

    }
}
