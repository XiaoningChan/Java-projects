package com.itheima.heap;

import java.util.Arrays;

//小顶堆
public class Minheap {
    int[] array;
    int size;
    public Minheap(int capacity){
        this.array = new int[capacity];
    }
    public Minheap(int[] array){
        this.array = array;
        this.size = array.length;
        heapify();
    }
    public boolean isFull(){
        return size == array.length;
    }
    //建堆
    private void heapify(){
        //r如何找到最后这个非叶子节点，size/2-1;这种找法基于索引以0开始
        for (int i = size/2-1; i >= 0; i--) {
            down(i);
        }
    }
    //删除堆顶元素；返回堆顶元素
    public int poll(){
        //增加判断，没有元素时报错
        int top = array[0];
        swap(0,size-1);
        size--;
        down(0);
        return top;
    }
    //删除指定索引处元素
    public int poll(int index){
        ////增加判断，没有元素时报错
        int deleted = array[index];
        swap(index,size-1);
        size--;
        down(index);
        return deleted;
    }
    //获取堆顶元素；returns:堆顶元素
    public int peek(){
        //增加判断，没有元素时报错
        return array[0];
    }
    //替换堆顶元素；params:replaced-新元素
    public void replace(int replaced){
        array[0] = replaced;
        down(0);
    }
    //堆的尾部添加元素；params:offered-被添加元素；returns:是否成功添加
    public boolean offer(int offered) {
        if(size == array.length){
            return false;
        }
        up(offered);
        size++;
        return false;
    }
    //将inserted元素上浮，直至offered大于父元素或到堆顶
    private void up(int offered){
        int child = size;
        while(child>0){
            int parent = (child-1)/2;
            if(offered < array[parent]){
                array[child] = array[parent];
            }else{
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }
    //将parent索引处的元素下潜：与两个孩子较大者交换，直至没有孩子孩子比他小
    private void down(int parent){
        int left = parent*2+1;
        int right = left +1;
        int min = parent;
        if(left < size && array[left] < array[min]){
            min = left;
        }
        if(right < size && array[right] < array[min]){
            min = right;
        }
        if(min != parent){ //找到了更小的孩子
            swap(min,parent);
            down(min);
        }
    }
    private void swap(int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
