package com.itheima.heap;

import java.util.Arrays;

//可以扩容的heap,max用于指定是大顶堆还是小顶堆
public class Heap {
    int[] array;
    int size;
    boolean max;
    public int getSize(){
        return size;
    }
    public Heap(int capacity,boolean max) {
        this.array = new int[capacity];
        this.max = max;
    }
    public boolean offer(int offered) {
        if(size == array.length){
            //扩容
            grow();
        }
        up(offered);
        size++;
        return false;
    }
    private void grow(){
        int capacity = size + (size >> 1);
        int[] newArray = new int[capacity];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
    }
    public int poll(){
        //增加判断，没有元素时报错
        int top = array[0];
        swap(0,size-1);
        size--;
        down(0);
        return top;
    }
    public int peek(){
        //增加判断，没有元素时报错
        return array[0];
    }

    private void up(int offered){
        int child = size;
        while(child>0){
            int parent = (child-1)/2;
            //max = true 的话，cmp = offered < array[parent]否则cmp = offered < array[parent]
            boolean cmp = max ? offered < array[parent]:offered > array[parent];
            if(cmp){
                array[child] = array[parent];
            }else{
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }
    private void down(int parent){
        int left = parent*2+1;
        int right = left +1;
        int maxOrmin = parent;
        if(left < size &&( max? array[left] > array[maxOrmin]:array[left] < array[maxOrmin])){
            maxOrmin = left;
        }
        if(right < size && ( max? array[left] > array[maxOrmin]:array[left] < array[maxOrmin])){
            maxOrmin = right;
        }
        if(maxOrmin != parent){
            swap(maxOrmin,parent);
            down(maxOrmin);
        }
    }
    private void swap(int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    public static void main(String[] args) {
        Heap left = new Heap(5,true);
        for (int i = 1; i <= 10; i++) {
            left.offer(i);
            System.out.println(Arrays.toString(left.array));
        }
    }
}
