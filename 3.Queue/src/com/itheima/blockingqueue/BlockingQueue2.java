package com.itheima.blockingqueue;
//双锁
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue2 <E> implements BlockingQueue<E>{
    private final E[] array;
    private int head;
    private int tail;
    private int size;
    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();
    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();

    public BlockingQueue2(int capacity) {
        array = (E[])new Object[capacity];
    }
    private boolean isEmpty(){
        return size == 0;
    }
    private boolean isFull(){
        return size == array.length;
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
            size++;
            /*
            * size++的执行步骤：
            * 1.读取成员变量size的值
            * 2.自增
            * 3.结果写会成员变量size
            * poll()也一样，因为使用两把锁会导致offer()和poll()交错执行，出错
            * 解决方案使用原子整数类*/
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
            size--;
            return e;
        }finally {
            headLock.unlock();
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
