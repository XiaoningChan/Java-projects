package com.itheima.heap;

import java.util.Arrays;

//大顶堆
public class Maxheap {
    int[] array;
    int size;
    public Maxheap(int capacity){
        this.array = new int[capacity];
    }
    public Maxheap(int[] array){
        this.array = array;
        this.size = array.length;
        heapify();
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
    //将inserted元素上浮，直至offered小于父元素或到堆顶
    private void up(int offered){
        int child = size;
        while(child>0){
            int parent = (child-1)/2;
            if(offered > array[parent]){
                array[child] = array[parent];
            }else{
                break;
            }
            child = parent;
        }
        array[child] = offered;

    }
    //将parent索引处的元素下潜：与两个孩子较大者交换，直至没有孩子过孩子没他大
    private void down(int parent){
        int left = parent*2+1;
        int right = left +1;
        int max = parent;
        if(left < size && array[left] > array[max]){
            max = left;
        }
        if(right < size && array[right] > array[max]){
            max = right;
        }
        if(max != parent){ //找到了更大的孩子
            swap(max,parent);
            down(max);
        }
    }
    private void swap(int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7} ;
        Maxheap maxheap = new Maxheap(array);
        System.out.println(Arrays.toString(maxheap.array));
        //利用大顶堆快速排序
        int[] array1 = {2,3,1,7,6,4,5};
        Maxheap heap = new Maxheap(array1);
        System.out.println(Arrays.toString(heap.array));
        while(heap.size > 1){
            heap.swap(0,heap.size-1);
            heap.size--;
            heap.down(0);
        }
        System.out.println(Arrays.toString(heap.array));
    }
}
