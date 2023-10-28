package com.itheima.recursion;

public class insertionSort {
    public static void sort(int[] a){ //设置好low=1,减少对调用者的暴露
        insertion(a,1);
    }
    private static void insertion(int[] a,int low){
        if(low == a.length){
            return;
        }
        int t = a[low];//t-需要插入未排序元素中最左元素,low为其索引值
        int i = low-1;//i-已排序区域最右元素索引值
        while(i>=0 && a[i]>t){//没有找到插入位置，继续往下比;当比到第一个（i=0）还大时,会进入循环使i=-1,故要限制i>0
                a[i+1] = a[i]; //空出插入位置
                i--;
        }
        if(i+1 != low){ //
            a[i+1] = t;//找到插入位置
        }
        insertion(a,low + 1);//递归控制用未排序的第几个元素来与已排序的元素比
        }
    }
