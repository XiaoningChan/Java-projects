package com.itheima.stack;
//LinkedListStack<E> 类中的 Stack<E> 标红并显示 "Interface expected here" 的原因是因为
// Java 中的 Stack 接口与 java.util.Stack 类有冲突。在 Java 中，Stack 既可以是一个接口，也可以是一个类，但这两者是不同的。
//把import java.util.Stack;删掉即可
import java.util.Iterator;
//单向链表加哨兵实现栈
public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    private int capacity;
    private int size;
    private Node<E> head = new Node<>(null,null);
    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }
    static class Node<E>{ // 节点类
        E value;
        Node<E> next;
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    //1.push():向栈顶压入元素;Params:value-待压入值;Returns:压入成功返回true,否则返回false
    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        head.next = new Node<>(value,head.next);
        size++;
        return true;
    }
    //2.从栈顶弹出元素；Returns:栈非空返回栈顶元素，栈为空返回null
    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        return first.value;
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != null;
            }
            @Override
            public E next() {
                E value = p.value;
                p = p. next;
                return value;
            }
        };
    }
}


