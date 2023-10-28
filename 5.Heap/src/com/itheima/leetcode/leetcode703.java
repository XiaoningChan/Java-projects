package com.itheima.leetcode;

import com.itheima.heap.Minheap;

//求数据流中的第k大元素——堆是最好的算法
public class leetcode703 {
    private Minheap heap;
    public leetcode703(int k,int[] nums){
        heap = new Minheap(k);
        for (int num:nums) {
            add(num);
        }
    }
    //此方法会被不断调用，模拟数据流中新来的元素
    public int add(int val){
        if(!heap.isFull()){
            heap.offer(val);
        }else if(val > heap.peek()){
            heap.replace(val);
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        leetcode703 test = new leetcode703(3,new int[]{4,5,8,2});
        System.out.println(test.add(3)); //4
        System.out.println(test.add(5)); //[5 5 8] 5
        System.out.println(test.add(10)); //[5 8 10] 5
        System.out.println(test.add(9)); //[8 9 10] 8
        System.out.println(test.add(4)); //[8 9 10] 8
    }
}
