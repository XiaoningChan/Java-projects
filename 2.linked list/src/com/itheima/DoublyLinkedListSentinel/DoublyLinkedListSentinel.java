package com.itheima.DoublyLinkedListSentinel;

import java.util.Iterator;
//双向链表带哨兵
//用迭代器来遍历
public class DoublyLinkedListSentinel implements Iterable<Integer> { //生成测试的方法：command +shift +T
    //链表节点类
    static class Node{
        Node pre;//上一个节点指针
        int value;//值
        Node next;//下一个节点指针
        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }

    }
    private Node head;//头哨兵
    private Node tail;//尾哨兵
    public DoublyLinkedListSentinel(){
        head = new Node(null,666,null);
        tail = new Node(null,888,null);
        head.next = tail;
        tail.pre = head;
    }
    private Node findNode(int index){
        int i = -1;
        for(Node p = head;p!=null;p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;//可能是输入的index不合法
    }
    public void addLast(int value){
        Node last = tail.pre;//通过尾哨兵拿到最后一个节点
        Node added = new Node(last,value,tail);
        last.next = added;
        tail.pre = added;
    }
    public void removeLast(){
        Node removed = tail.pre;
        if(removed == head){
            throw new IllegalArgumentException(
                    String.format("index不合法"));
        }
        Node pre = removed.pre;
        pre.next = tail;
        tail.pre = pre;
    }
    public void insert(int index,int value){
         Node pre = findNode(index-1);
         if(pre == null){
             throw new IllegalArgumentException(
                     String.format("index不合法"));
         }
         Node next = pre.next;
         Node inserted = new Node(pre,value,next);
         pre.next = inserted;
         next.pre = inserted;
    }
    public void removeFirst(){
        remove(0);
    }
    public void remove(int index){
        Node pre = findNode(index-1);
        if(pre == null){
            throw new IllegalArgumentException(
                    String.format("index不合法"));
        }
        Node removed = pre.next;
        if(removed == tail){
            throw new IllegalArgumentException(
                    String.format("index不合法"));
        }
        Node next = removed.next;
        pre.next = next;
        pre = next.pre;
    }
    @Override
    public Iterator<Integer>iterator(){
        return new Iterator<Integer>() {
            Node p = head.next;// 起点
            @Override
            public boolean hasNext() {
                return p != tail;//不等于尾哨兵的时候，hasNext返回 true,继续遍历,当等于尾哨兵时hasNext返回false,停止遍历
            }
            @Override
            public Integer next() { //返回当前pointer指针指向的值，并指向下一个节点
                int value = p.value; //1。记录下当前指针的值
                p = p.next; // 3.pointer指针指向下一个节点
                return value; //2。返回这个值
            }
        };
    }



}
