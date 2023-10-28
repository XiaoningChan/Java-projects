package com.itheima.circularLinkedListSentinel;

import java.util.Iterator;

//双向环形链表
public class DoublyCircularLinkedListSentinel implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };

    }
    //节点类
    private static class Node{
        Node pre;
        int value;
        Node next;
        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
    private Node sentinel = new Node(null,-1,null);
    public DoublyCircularLinkedListSentinel(){
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }
    //添加到第一个
    //Params:value-待添加值
    public void addFirst(int value){
        Node a = sentinel; //可以理解为把sentinel的地址给a
        Node b = sentinel.next; ////可以理解为把sentinel.next(原来的第一个节点)的地址给b
        Node added = new Node(a,value,b);
        a.next = added;
        b.pre = added;
    }
    public void addLast(int value){
        Node a = sentinel.pre;
        Node b = sentinel;
        Node added = new Node(a,value,b);
        a.next = added;
        b.pre = added;
    }
    public void removeFirst(){
        Node removed = sentinel.next;
        if(removed == sentinel){
            throw new IllegalArgumentException(
                    String.format("index不合法"));
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.pre = a;
    }
    public void removeLast(){
        Node removed = sentinel.pre;
        if(removed == sentinel){
            throw new IllegalArgumentException(
                    String.format("index不合法"));
        }
        Node a = removed.pre;
        Node b = sentinel;
        a.next = b;
        b.pre = a;
    }
    public void removeByValue(int value){
        Node removed = findByValue(value);
        if(removed ==null){
            return;//不用删
        }
        Node a = removed.pre;
        Node b = removed.next;
        a.next = b;
        b.pre = a;
    }
    private Node findByValue(int value){
        Node p = sentinel.next;
        while (p != sentinel){

            if(p.value == value){
                return p;
            }
            p = p.next;
        }
        return null;
    }

}
