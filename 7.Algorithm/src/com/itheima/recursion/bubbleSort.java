package com.itheima.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 递归冒泡排序：
 ·将数组划分成两部分[0...j][j+1...a.length-1]
 ·左边[0...j]是未排序部分
 ·右边[j+1..a.length-1]
 ·未排序区间内，相邻的的两个元素比较，如果前一个大于后一个，则交换位置
 */
public class bubbleSort {
    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        System.out.println(Arrays.toString(a));
        bubble2(a,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void bubble(int[] a,int j){
        if(j == 0){
            return;
        }
        for (int i = 0; i < j; i++) {
            if(a[i]>a[i+1]){
                int t = a[i];
                a[i] = a[i+1];
                a[i+1] = t;
            }
        }
        bubble(a,j-1);
    }
    //上面这种冒泡的缺点：一次for循环完可能前面的未排序部分也已经排好了，但还是要j-1接着递归知道j=0
    //优化：
    public static void bubble2(int[] a,int j){
        if(j == 0){
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if(a[i]>a[i+1]){
                int t = a[i];
                a[i] = a[i+1];
                a[i+1] = t;
                x = i;
            }
        }
        bubble(a,x);
    }
}
