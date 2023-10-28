package com.itheima.stack;
import java.util.Iterator;
/**
 底       顶
 0  1  2  3
 a  b  c  d
             t
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private E[] array;
    private int top;//栈顶指针
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }//通过强制转换来创建数组
    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        array[top] = value;
        top ++;
        //也可array[top++] = value;
        return true;
    }
    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        E value = array[top-1];
        top--;
        //也可E value = array[--top]；top先自减
        return value;
    }
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[top-1];
    }
    @Override
    public boolean isEmpty() {
        return top == 0;
    }
    @Override
    public boolean isFull() {
        return top == array.length;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;
            @Override
            public boolean hasNext() {
                return p >0;
            }
            @Override
            public E next() {
                E value = array[p--];
                return value;
            }
        };
    }
}
