package com.itheima.LinkedListDeque;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class LinkedListDequeTest {

    @org.junit.jupiter.api.Test
    public void offer() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        assertFalse(deque.offerLast(6));
        assertIterableEquals(List.of(3,2,1,4,5),deque);
    }
    @org.junit.jupiter.api.Test
    public void poll() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
        assertEquals(1,deque.pollFirst());
        assertEquals(2,deque.pollFirst());
        assertEquals(5,deque.pollLast());
        assertEquals(4,deque.pollLast());
        assertEquals(3,deque.pollLast());
        assertNull(deque.pollLast());
        assertTrue(deque.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void pollLast() {
    }

    @org.junit.jupiter.api.Test
    void peekFirst() {
    }

    @org.junit.jupiter.api.Test
    void peekLast() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void isFull() {
    }
}