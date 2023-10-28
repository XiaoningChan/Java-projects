package com.itheima.blockingqueue;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

//线程上锁方法：1.synchronized关键字，功能少;2.reentrantlock实现类，可重入锁，功能多
public class TestThreadUnsafeLock {
    private final String[] array = new String[10];
    private int tail = 0;
    ReentrantLock lock = new ReentrantLock();//通过 ReentrantLock实现类创建锁对象
    public void offer(String e){
        lock.lock();//加锁；若是lock.lockInterruptibly()可以在阻塞状态随时打断
        try {
            array[tail] = e;
            tail++;
        } finally {
            lock.unlock();//解锁
        }
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
