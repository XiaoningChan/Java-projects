package com.itheima.leetcode;

import com.itheima.heap.Minheap;
//求数组中第k大元素，堆不是最好的方法，有更好的排序算法
/*
*解题思路：
* 1.向小顶堆放入前k个元素
* 2.剩余元素
*   若<=堆顶元素，则略过
*   若>堆顶元素，则替换堆顶元素
* 3.这样小堆顶始终保持的是到目前为止前k大的元素
* 4.循环结束，堆顶元素即为第k大元素
 */
public class leetcode215 {
    public int findkthlargest(int[] numbers,int k){
        Minheap heap = new Minheap(k);
        for (int i = 0; i < k; i++) {
            heap.offer(numbers[i]);
        }
        for (int i = k; i < numbers.length; i++) {
            if(numbers[i] > heap.peek()){
                heap.replace(numbers[i]);
            }
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        //应为5
        System.out.println(new leetcode215().findkthlargest(new int[]{3,2,1,5,6,4},2));
        //应为4
        System.out.println(new leetcode215().findkthlargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
