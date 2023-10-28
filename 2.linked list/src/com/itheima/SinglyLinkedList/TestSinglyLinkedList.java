package com.itheima.SinglyLinkedList;

import org.junit.Assert;

public class TestSinglyLinkedList {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop(value->{
            System.out.println(value);
        });
        list.test();
        list.insert(3,5);
//        for(Integer value:list){
//            System.out.println(value);
//        }
//        SinglyLinkedListIterator list = new SinglyLinkedListIterator();
//            list.addFirst(1);
//            list.addFirst(2);
//            list.addFirst(3);
//            list.addFirst(4);
//            System.out.println("----------------------------");
//            for(Integer value:list){
//                System.out.println(value);
//            }
//        SinglyLinkedListIterator list = new SinglyLinkedListIterator();
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
//        list.addFirst(4);
        }
    }



