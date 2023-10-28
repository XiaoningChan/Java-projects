package com.itheima.leetcode;

import com.itheima.heap.Heap;

import java.util.Arrays;

//数据流的中位数
/*
* 大顶堆>   <小顶堆
* 1 2 3 7  8 9 10
* 为了保证两边数据量平衡：
* ·两边个数一样时，左边个数加一
* ·两边个数不一样时，右边个数加一
* 但是，随便一个数能直接加入吗？
* ·左边个数加一时，把新元素加在右边，弹出右边最小的加入左边
* ·右边个数加一时，把新元素加在左边，弹出左边最大的加入右边
*/
public class leetcode295 {
    public void addNum(int num){
        if(left.getSize() == right.getSize()){
            right.offer(num);
            left.offer(right.poll());
        }else{
            left.offer(num);
            right.offer(left.poll());
        }
    }
    //·两边元素个数一样，左右各取堆顶元素取平均
    //·左边多一个，取左边堆顶元素
    public double findMedian(){
        if(left.getSize() == right.getSize()){
            return (left.peek()+ right.peek())/2.0;
        }else{
            return left.peek();
        }
    }
    private Heap left = new Heap(10,true);//true是大顶堆
    private Heap right = new Heap(10,false);//false是小顶堆
/*    @Override
    public String toString(){
        int size = left.size;
        int[] left = new int[size];
        for (int i = 0; i < left.length; i++) {
            left[size-1-i] = this.left.array[i];
        }
        int[] right = Arrays.copyOf(this.right.array,this.right.size);
        return Arrays.toString(left) + "<->" + Arrays.toString(right) ;
    }*/
}
