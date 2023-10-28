package com.itheima.priorityQueue;
import com.itheima.LinkedListQueue.Queue;
//基于无序数组实现
//Type parameters:<E>-队列中元素类型，必须实现priority接口
public class PriorityQueue1<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;
    public PriorityQueue1(int capacity){
        array = new Priority[capacity];
    }
    @Override //O(1)
    public boolean offer(E e) {
        if(isFull()){
            return false;
        }
        array[size] = e;
        size++;
        //可简写为array[size++] = e
        return true;
    }
    //返回优先级最高的索引值
    private int selectMax(){
        int max = 0;
        for (int i = 0; i <size ; i++) {
            if(array[i].priority()>array[max].priority()){
                max = i;
            }
        }
        return max;
    }

    @Override // O(n)
    public E poll() {
        if(isEmpty()){
            return null;
        }
        int max = selectMax();
        E e = (E)array[max];
        remove(max);
        return e;
    }
    private void remove(int index){
        if(index < size-1){
            //移动被删除索引处元素后的元素
            System.arraycopy(array,index+1,array,index,size-1-index);
        }
        //若index = size-1，则不用移动
        size--;
        array[size] = null;
    }
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        int max = selectMax();
        return (E)array[max];
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
