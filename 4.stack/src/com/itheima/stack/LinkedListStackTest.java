package com.itheima.stack;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    @org.junit.jupiter.api.Test
    void push() {
        LinkedListStack<Object> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.push(4));
        assertIterableEquals(List.of(3,2,1),stack);
    }

    @org.junit.jupiter.api.Test
    void pop() {
    }

    @org.junit.jupiter.api.Test
    void peek() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void isFull() {
    }
}