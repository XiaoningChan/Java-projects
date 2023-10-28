package com.itheima.SinglyLinkedList;

import java.util.function.Consumer;

//单向链表
public class SinglyLinkedList {//整体
    private Node head;//头指针
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
    public void loop3(){
        recursion(head);
    }
    public void recursion(Node curr){//某个节点要进行的操作
        if(curr == null){
            return;
        }
        System.out.println("before"+curr.value);//先打印再递归：1,2,3,4
        recursion(curr.next);
        System.out.println("after"+curr.value);//先递归再打印：4,3,2,1
        //AOP的前置通知和后置通知可以利用这个
    }
    //loop3和recursion可改写为如下范型容器
    public void loop3(Consumer<Integer> before,Consumer<Integer> after){
        recursion(head,before,after);
    }
    public void recursion(Node curr,Consumer<Integer> before,Consumer<Integer> after){
        if(curr == null){
            return;
        }
        before.accept(curr.value);//1,2,3,4
        recursion(curr.next,before,after);
        after.accept(curr.value);//4,3,2,1
    }
    //

    private Node findLast(){
        if(head == null){//空链表
            return null;
        }
        Node p;
        for(p = head;p.next!=null;p=p.next){

        }
        return p;
    }
    public void addlast(int value){
        Node last = findLast();
        if(last == null){
            addFirst(value);
        }
        last.next = new Node(value,null);//把尾部加进去的节点给找到的原链表的指针

    }
    //遍历返回所有节点的索引
    public void test(){
        int i = 0;
        for(Node p =head;p != null;p=p.next,i++){//java中for循环表达式中第一部分只能定义一个变量，第三个位置支持多条表达式
            System.out.println(p.value+"索引是"+i);
        }
    }
    //改造成我们需要的方法：根据给定索引位置返回节点，因为返回的节点不想暴露给外界，所以设为private
    private Node findNode(int index){
        int i =0;
        for(Node p =head;p != null;p=p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;//没找到
    }
    //提供对外方法返回索引位置节点的值
    public int get(int index){
        Node node = findNode(index);
        if(node == null){
            throw new IllegalArgumentException(String.format("index[%d]不合法%n",index));
        }
        return node.value;
    }
    //向任意索引位置插入
    public void insert(int index,int value){
        if(index == 0){
            addFirst(value);
            return;
        }
        Node pre = findNode(index-1);//findNode找到上一个节点(包含value和next)，定义pre来接收
        if(pre ==null){
            throw new IllegalArgumentException(
                    String.format("index[%d]不合法%n",index));
        }
        pre.next = new Node(value,pre.next);//让要插入的的索引前一个节点的指针指向插入的节点，插入的节点的指针指向前一个节点指向的节点
    }
    //删除第一个节点
    public void removeFirst(){
        //1.头head = 第一个节点
        //2.head.next就是指向第二个节点
        //3.删除第一个节点就是将第二个节点指向头即head =head.next
        if(head == null) {
            throw new IllegalArgumentException(
                    String.format("index不合法"));
        }
        head =head.next;
    }
    //删除任意索引处节点
    public void remove(int index){
        //1.删除的是第一个节点
        if(index == 0){
            removeFirst();
            return;
        }
        Node pre = findNode(index-1);//findNode找到上一个节点(包含value和next)，定义pre来接收
        //2.链表为空
        if(pre == null){
            throw new IllegalArgumentException(
                    String.format("index不合法"));
        }
        Node removed = pre.next;//pre.net指向的是被删除的节点，故这里定义节点removed来接收被删除节点
        //3.被删除的节点不存在
        if (removed == null){
            throw new IllegalArgumentException(
                    String.format("index不合法"));
        }
        pre.next = removed.next;//removed.next指被删除节点后面的那个节点，删除节点就是让指向被删除节点的指针指向被删除节点后面的那个节点
    }

}

