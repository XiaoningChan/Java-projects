package com.itheima.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class arrayQueue3<E> implements Queue<E>,Iterable<E> {
    private final E[] array; //E[] array看作一个常量
    private int head = 0;
    private int tail = 0;
    public arrayQueue3(int capacity) {
        array = (E[]) new Object[capacity]; //不用空出0位了
    }
    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        array[tail%array.length] = value;
        tail++;
        return true;
    }
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E value = array[head %array.length];
        head++;
        return value;
    }
    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return array[head %array.length];
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
    public boolean isFull() { //系统里父类没有这个方法，奇怪
        return tail - head == array.length;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return head != tail;
            }

            @Override
            public E next() {
                E value = array[p %array.length];
                p++;
                return null;
            }
        };
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }



    @Override
    public E remove() {
        return null;
    }



    @Override
    public E element() {
        return null;
    }


}
