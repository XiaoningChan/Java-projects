package com.itheima.priorityQueue;

import com.itheima.LinkedListQueue.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueue3Test {

    @Test
    public void offer() {
    }

    @Test
    public void poll() {
        PriorityQueue3<Entry> queue = new PriorityQueue3<>(5);
        queue.offer(new Entry("task1",4));
        queue.offer(new Entry("task2",3));
        queue.offer(new Entry("task3",2));
        queue.offer(new Entry("task4",5));
        queue.offer(new Entry("task5",1));
        assertFalse(queue.offer(new Entry("task6",7)));

        assertEquals(5, queue.poll().priority());
        assertEquals(4, queue.poll().priority());
        assertEquals(3, queue.poll().priority());
        assertEquals(2, queue.poll().priority());
        assertEquals(1, queue.poll().priority());

    }

    @Test
    void peek() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void isFull() {
    }
}