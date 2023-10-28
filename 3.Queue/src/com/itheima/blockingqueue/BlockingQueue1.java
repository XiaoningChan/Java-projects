package com.itheima.blockingqueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue1<E> implements BlockingQueue<E>{
    private final E[] array;
    private int head;
    private int tail;
    private int size;

    public BlockingQueue1(int capacity) {
        array = (E[])new Object[capacity];
    }
    private ReentrantLock lock = new ReentrantLock();
    private Condition headwaits = lock.newCondition();
    private Condition tailwaits = lock.newCondition();
    private boolean isEmpty(){
        return size == 0;
    }
    private boolean isFull(){
        return size == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException { //poll 等待队列非空，一旦offer了就唤醒poll
        lock.lockInterruptibly();
        try{
            while (isFull()){ //while循环防止虚假唤醒
                tailwaits.await();
            }
            array[tail] = e;
            if(++tail ==array.length){
                tail = 0;
            }
            size++;
            headwaits.signal();
        }finally {
            lock.unlock();
        }
    }
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {// 设定时间上线，超过时间上限则自动解锁
        lock.lockInterruptibly();
        try{
            long t = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()){ //while循环防止虚假唤醒
                if(t <= 0){
                    return false;
                }
                t = tailwaits.awaitNanos(t); //最多等待多少纳秒,返回值代表剩余时间
            }
            array[tail] = e;
            if(++tail ==array.length){
                tail = 0;
            }
            size++;
            headwaits.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }
    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try{
            while (isEmpty()){ //while循环防止虚假唤醒
                headwaits.await();
            }
            E e = array[head];
            array[head] = null; //help GC
            if(++head == array.length){
                head = 0;
            }
            size--;
            tailwaits.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }
    @Override
    public String toString() {
        // 返回队列的内容，这里可以根据你的具体实现方式来获取队列的元素信息并返回
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

}
