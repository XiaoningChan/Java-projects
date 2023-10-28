package com.itheima.ArrayDeque;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDequeTest {

    @Test
    public void offer() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(3);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        assertFalse(deque.offerLast(4));
        assertIterableEquals(List.of(2,1,3),deque);
    }
    @Test
    public void poll() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(7);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerFirst(4);
        deque.offerFirst(5);
        deque.offerFirst(6);
        deque.offerFirst(7);
        assertIterableEquals(List.of(7,6,5,4,1,2,3),deque);
        assertTrue(deque.isFull());
    }
    @Test
    void peek() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(7);
        deque.offerFirst(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        assertEquals(4,deque.peekLast());
        assertEquals(3,deque.peekFirst());
    }

    @Test
    void peekLast() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void isFull() {
    }
}