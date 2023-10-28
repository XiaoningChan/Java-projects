package com.itheima.ArrayDeque;
import com.itheima.LinkedListDeque.Deque;
import java.util.Iterator;
//双端队列-基于循环数组实现
//tail停下来的位置不存储，会浪费一个位置
//Type parameters:<E>-队列中元素类型
//注意垃圾回收
/**
 h-head;t-tail
     h
     t
     0  1  2
     7     3
     6  5  4
 offerLast(a)  先添加元素tail++
 offerLast(b)
 offerFirst(c) 先head--再添加元素
 pollFirst()   先获取要移除的值head++
 pollLast()    先tail--再取要移除的值
 */
public class ArrayDeque<E> implements Deque<E>,Iterable<E> {
    static int inc(int i,int length){
        if(i+1>=length){
            return 0;
        }
        return i+1;
    } // increment
    static int dec(int i,int length){  //decrement
        if(i-1<0){
            return length-1;
        }
        return i-1;
    }
    E[] array;
    int head;
    int tail;
    public ArrayDeque(int capacity) {
        array = (E[])new Object[capacity+1];
    }
    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        head = dec(head, array.length);
        array[head] = e;
        return true;
    }
    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }
    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        E e = array[head];
        // 为了及时释放内存，将删除前head索引处元素设为null,这样e就不会再引用了， help GC帮助垃圾回收
        array[head] = null;
        head = inc(tail,array.length);
        return e;
    }
    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        tail = dec(tail,array.length);
        E e = array[tail];
        array[tail] =null; //help GC
        return e;
    }
    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        return array[head];
    }
    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        return array[dec(tail,array.length)];
    }
    @Override
    public boolean isEmpty() {
        return head == tail;
    }
    @Override
    public boolean isFull() {
        if(tail>head){
            return tail-head == array.length-1;
        }else if(tail<head){
            return head-tail == 1;
        }else{
            return false;
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }
            @Override
            public E next() {
                E e = array[p];
                p = inc(p,array.length);
                return e;
            }
        };
    }
}
