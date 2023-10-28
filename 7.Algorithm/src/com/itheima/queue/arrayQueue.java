package com.itheima.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
/**
 仅用head,tail判断空满，head,tail即为索引值
 Type parameters:<E>-队列中元素类型
 */
public class arrayQueue<E> implements Queue<E>,Iterable<E>{
    private E[] array;
    private int head = 0;
    private int tail = 0;
    public arrayQueue(int capacity) {
        array = (E[]) new Object[capacity+1];
    }
    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        array[tail] = value; // 把值给tail
        tail = (tail+1)% array.length; //将tail后移一位
        return true;
    }
    @Override
    public E poll() { //从队列头部移除元素
        if(isEmpty()){
            return null;
        }
        E value = array[head]; //获取头部元素
        head = (head+1)% array.length; //移除头部元素，头指针向后移动
        return value;
    }
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[head];
    }
    @Override
    public boolean isEmpty() {
        return head ==tail;
    }
    public boolean isFull() { //系统里父类没有这个方法，奇怪
        return (tail+1)% array.length==head;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }
            @Override
            public E next() {
                E value = array[p];
                p = (p+1)%array.length;
                return value;
            }
        };
    }

    @Override
    public int size() {
        return 0;
    }
    @Override
    public E element() {
        return null;
    }


    @Override
    public boolean contains(Object o) {
        return false;
    }



    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return Queue.super.toArray(generator);
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return Queue.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public void clear() {
    }
    @Override
    public Spliterator<E> spliterator() {
        return Queue.super.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return Queue.super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return Queue.super.parallelStream();
    }
    @Override
    public E remove() {
        return null;
    }


}
