package com.itheima.leetcode;

import java.util.PriorityQueue;

public class leetcode295_2 {
    public void addNum(int num){
        if(left.size() == right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else{
            left.offer(num);
            right.offer(left.poll());
        }
    }
    public double findMedian(){
        if(left.size() == right.size()){
            return (left.peek()+ right.peek())/2.0;
        }else{
            return left.peek();
        }
    }
    //大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a) //Integer.compare(a,b) return -1 if b<a;0 if a=b ;1 if b>a
    );
    //小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>(
            (a,b) -> Integer.compare(a,b) //Integer.compare(a,b) return -1 if a<b;0 if a=b ;1 if a>b
    );

    public static void main(String[] args) {

    }
}
