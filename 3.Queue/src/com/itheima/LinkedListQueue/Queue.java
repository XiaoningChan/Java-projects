package com.itheima.LinkedListQueue;
//自定义Queue接口原因是java提供的接口东西太多，还有collection等
public interface Queue<E> {
    //向队尾插入值；params:value-待插入值；Returns:插入成功返回true,插入失败返回false
    boolean offer(E value);
    //从队头获取值，并移除；Returns:如果队列非空返回对头值，否则返回null
    E poll();
    //从队头获取值，不移除
    E peek();
    //队列是否为空；Returns:空，返回true,否则返回false
    boolean isEmpty();
    //队列是否为满；Returns:满，返回true,否则返回false
    boolean isFull();
}
