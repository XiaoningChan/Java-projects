package com.itheima.priorityQueue;
import com.itheima.LinkedListQueue.Queue;
//基于有序数组实现；Type params:<E>-队列中元素类型，必须实现priority接口
public class PriorityQueue2<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;
    public PriorityQueue2(int capacity){
        array = new Priority[capacity];
    }
    @Override
    public boolean offer(E e) {
        if(isFull()){
            return false;
        }
        insert(e);
        size++;
        return true;
    }
    //O(n)
    private void insert(E e){
        int i = size-1;
        while(i>=0 && array[i].priority()>e.priority()){
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = e;
    }
    //返回优先级最高的索引值
    //O(1)
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E e = (E)array[size-1];
        size--;
        array[size] = null;  // help GC
        return e;
    }
    private void remove(int index){
        if(index < size-1){
            //移动被删除索引处元素后的元素
            System.arraycopy(array,index+1,array,index,size-1-index);
        }
        //若index = size-1，则不用移动
        size--;
    }
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return (E)array[size-1];
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
