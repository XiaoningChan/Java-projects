package com.itheima.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue2_2AtomicInteger <E> implements BlockingQueue<E>{
    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size = new AtomicInteger();// 原子整数类实现对象
    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();
    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();

    public BlockingQueue2_2AtomicInteger(int capacity) {
        array = (E[])new Object[capacity];
    }
    private boolean isEmpty(){
        return size.get() == 0;
    }
    private boolean isFull(){
        return size.get() == array.length;
    }
    @Override
    public void offer(E e) throws InterruptedException {
        tailLock.lockInterruptibly();
        try{
            //1.队列满则等待
            if(isFull()){
                tailWaits.await();
            }
            //2.则入列
            array[tail] = e;
//            tail++;
//            if(tail == array.length){
//                tail = 0;
//            }
            if(++tail == array.length){
                tail = 0;
            }
            //3.修改size
            size.getAndIncrement();
            /*
             * size++的执行步骤：
             * 1.读取成员变量size的值
             * 2.自增
             * 3.结果写会成员变量size
             * poll()也一样，因为使用两把锁会导致offer()和poll()交错执行，出错
             * 解决方案使用原子整数类*/
            headLock.lock(); //因为 headWaits与tailLock不配对无法执行唤醒，所以需要上配对的headLock才能配对唤醒
            try{
                headWaits.signal();
            }finally {
                headLock.unlock();
            }
        }finally {
            tailLock.unlock();
        }
    }
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {
        headLock.lockInterruptibly();
        try{
            if(isEmpty()){
                headWaits.await();
            }
            E e = array[head];
            array[head] = null;
//            head++;
//            if(head == array.length){
//                head = 0;
//            }
            if(++head == array.length){
                head = 0;
            }
            size.getAndDecrement();
            tailLock.lock();
            try{
                tailWaits.signal();
            }finally {
                tailLock.unlock();
            }
            return e;
        }finally {
            headLock.unlock();
        }
    }
    @Override
    public String toString() {
        // 返回队列的内容，这里可以根据你的具体实现方式来获取队列的元素信息并返回
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size.get(); i++) {
            result.append(array[i]);
            if (i < size.get() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
