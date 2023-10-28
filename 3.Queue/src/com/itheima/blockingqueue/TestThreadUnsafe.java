package com.itheima.blockingqueue;

import java.util.Arrays;

public class TestThreadUnsafe {
    private final String[] array = new String[10];
    private int tail = 0;
    public void offer(String e){
        array[tail] = e;
        tail++;
    }
    @Override
    public String toString(){
        return Arrays.toString(array);
    }
    public static void main(String[] args){
        TestThreadUnsafe queue = new TestThreadUnsafe();
        queue.offer("e1");
        queue.offer("e2");
    /*正常情况下：
     [e1,e2,null,null,null,null,null,null]
       0  1   2    3    4    5    6    7
    */
    new Thread(()->queue.offer("e1"),"t1").start();
    new Thread(()->queue.offer("e2"),"t2").start();
    //多线程下，第一个线程array[tail] = e1后还没来得及tail++，第二个线程就开始执行array[tail] = e2，导致e1被覆盖
    }

}
