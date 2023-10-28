package com.itheima.SinglyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

//单向链表
public class SinglyLinkedListIterator implements Iterable<Integer>{
    private Node head = null;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
            @Override
            public boolean hasNext() {//是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() {//返回当前值，并窒息那个下一个元素
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    //节点类
    private static class Node{//放成内部类是为了封装，对用户暴露少点
        int value;//值
        Node next;//下一个节点指针
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    //在链表首部添加节点
    public void addFirst(int value){
        //1.链表为空
        //head = new Node(value,null);
        //2.链表非空
        //head = new Node(value,head);
        //3.简化：同时可表示链表空和非空2种情况
        head = new Node(value,head);
    }
    //遍历，为不与接口中的foreach冲突，命名为loop
    public void loop(Consumer<Integer> consumer){
        Node p = head;
        while(p != null){
            consumer.accept(p.value);
            p=p.next;
        }
    }
    public void loop2(Consumer<Integer> consumer){
        for(Node p = head;p != null;p = p.next){
            consumer.accept(p.value);
        }
    }
    private void loop3(){
        recursion(head);

    }
    private void recursion(Node curr){  //把recursion当作针对某一个节点要进行的操作
        if(curr == null){
            return;
        }
        System.out.println(curr.value);
        recursion(curr.next);

    }


}

