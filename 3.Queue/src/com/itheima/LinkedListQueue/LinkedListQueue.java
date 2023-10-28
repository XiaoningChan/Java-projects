package com.itheima.LinkedListQueue;
import java.util.Iterator;
public class LinkedListQueue<E> implements Queue<E>,Iterable<E> {
    private static class Node<E> { // 节点类
        E value;
        Node next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<E>(null, null); //创建节点类对象
    private Node<E> tail = head;
    private int size;//节点数
    private int capacity = Integer.MAX_VALUE;//容量,若没有指定，则按最大值

    public LinkedListQueue(int capacity) { //有参构造器
        this.capacity = capacity;
        tail.next = head;
    }

    public LinkedListQueue() { //创建链表队列
        tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        if (size == capacity) {
            return false; //终止后面的操作
        }
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public E poll() { //从队列头部（如图中1）获取值，并移除；若队列非空返回队列头部值，否则返回null
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail) {
            tail = head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() { //从队列头部（如图中1）获取值，不移除；若队列非空返回队列头部值，否则返回null
        if (isEmpty()) {
            return null;
        }
        return (E) head.next.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {  //创建迭代器对象
            Node<E> p = head.next;  //1.定义一个指针p 表示迭代起点

            @Override
            public boolean hasNext() { //3.判断是否还有节点以确定是否继续
                return p != head;
            }

            @Override
            public E next() {       //2.进行迭代，返回节点值
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
