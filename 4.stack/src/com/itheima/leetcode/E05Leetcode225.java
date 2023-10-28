package com.itheima.leetcode;

import com.itheima.queue.arrayQueue3;

/**
 单队列模拟栈：
   1.调用push,pop等方法次数最多100
   2.每次调用pop和top都能保证栈不为空
 栈顶     栈底      将a,b弹出压到队列尾     栈顶     栈底
 a    b    c   --------------------->   c    b   a
 队列头   队列尾                          队列头   队列尾
 queue.offer(a)
 queue.offer(b)
 queue.offer(c)
 push:添加：将新加入元素前面的所有元素从队列头移到队列尾
 pop:移除：直接移除队列头元素
 */
public class E05Leetcode225 {
    arrayQueue3<Integer> queue = new arrayQueue3<>(100);
    private int size = 0;
    public void push(int x){
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }
    public Integer pop(){
        size--;
        return queue.poll();
    }
    public int top(){
        return queue.peek();
    }
    public boolean empty(){
        return queue.isEmpty();
    }

}
