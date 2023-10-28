package com.itheima.blockingqueue;
//使用级联唤醒是为了提高性能：当有offer1,offer2,offer3和多个poll时不用每个offer加完元素就唤醒一次而是offer1加完headWaits.signal()唤醒poll()后
//由poll()负责唤醒poll2(),poll3()
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue2_4AtomicInteger_DeadLock_CascadeWakeup <E> implements BlockingQueue<E>{
    private final E[] array;
    private int head;
    private int tail;
    private int c;//AtomicInteger size添加前元素个数
    private AtomicInteger size = new AtomicInteger();// 原子整数类实现对象
    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();
    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();

    public BlockingQueue2_4AtomicInteger_DeadLock_CascadeWakeup(int capacity) {
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
            c = size.getAndIncrement();//getAndIncrement()获取旧的size值c再自增
            if(c+1<array.length){
                tailWaits.signal();
            }
        }finally {
            tailLock.unlock();
        }
        if (c == 0) { //offer1,offer2,offer3
            headLock.lock(); //因为 headWaits与tailLock不配对无法执行唤醒，所以需要上配对的headLock才能配对唤醒
            try{
                headWaits.signal();
            }finally {
                headLock.unlock();
            }
        }
    }
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {
        E e;
        int c;//取走前元素个数
        headLock.lockInterruptibly();
        try{
            if(isEmpty()){
                headWaits.await();
            }
            e = array[head];
            array[head] = null;
//            head++;
//            if(head == array.length){
//                head = 0;
//            }
            if(++head == array.length){
                head = 0;
            }
            c = size.getAndDecrement();
            if(c>1){
                headWaits.signal();
            }
        }finally {
            headLock.unlock();
        }
        //队列从满->不满时由poll唤醒等待不满的offer线程
        if (c == array.length) {
            tailLock.lock();
            try{
                tailWaits.signal();
            }finally {
                tailLock.unlock();
            }
        }
        return e;
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
