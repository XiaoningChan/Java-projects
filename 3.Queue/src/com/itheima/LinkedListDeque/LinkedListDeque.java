package com.itheima.LinkedListDeque;
import java.util.Iterator;
import java.util.LinkedList;
//双端队列-基于双向环形队列
public class LinkedListDeque<E> implements Deque<E>,Iterable {
    static class Node<E>{
        Node<E> pre;
        E value;
        Node<E> next;
        public Node(Node<E> pre, E value, Node<E> next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
    int capacity;
    int size;
    Node<E> sentinel = new Node<>(null,null,null);
    public LinkedListDeque(int capacity){
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }
    //向头部添加：a added b
    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> added = new Node<>(a,e,b);
        a.next = added;
        b.pre = added;
        size++;
        return true;
    }
    //向尾部添加：a added b--->a 为最后一个元素，b为尾哨兵
    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        Node<E> a = sentinel.pre;
        Node<E> b = sentinel;
        Node<E> added = new Node<>(a,e,b);
        a.next = added;
        b.pre = added;
        size++;
        return true;
    }
    //移除第一个元素 a removed b--->a 为哨兵，b为第一个元素
    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> a = sentinel;
        Node<E> removed = sentinel.next;
        Node<E> b = removed.next;
        a.next = b;
        b.pre = a;
        size--;
        return removed.value;
    }
    //移除最后一个元素 a removed b--->a 为倒数第二个元素，b为尾哨兵
    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        Node<E> b = sentinel;
        Node<E> removed = sentinel.pre;
        Node<E> a = removed.pre;
        b.pre = a;
        a.next = b;
        size--;
        return removed.value;
    }
    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        return sentinel.next.value;
    }
    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        return sentinel.pre.value;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean isFull() {
        return size == capacity;
    }
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }
            @Override
            public Object next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
