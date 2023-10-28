package com.itheima.circularLinkedListSentinel;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyCircularLinkedListSentinelTest {

//    @Test
//    public void iterator() {
//    }

    @Test
    public void addFirst() {
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        assertIterableEquals(List.of(5, 4, 3, 2, 1), list); //List 中的L要大写
    }

    @Test
    public void addLast() {
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        assertIterableEquals(List.of(1, 2, 3, 4, 5), list); //List 中的L要大写
    }

    @Test
    public void removeFirst() {
        DoublyCircularLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(5), list);
        list.removeFirst();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

//    private DoublyCircularLinkedListSentinel getList() {
//        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        list.addLast(5);
//        return list;
//    }

    @Test
    public void removeLast() {
        DoublyCircularLinkedListSentinel list = getList();
        list.removeLast();
        assertIterableEquals(List.of(1,2,3,4), list);
        list.removeLast();
        assertIterableEquals(List.of(1,2,3), list);
        list.removeLast();
        assertIterableEquals(List.of(1,2), list);
        list.removeLast();
        assertIterableEquals(List.of(1), list);
        list.removeLast();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }
    @Test
    public void removeByValue(){
        DoublyCircularLinkedListSentinel list = getList();
        list.removeByValue(5);
        assertIterableEquals(List.of(1,2,3,4), list);
        list.removeByValue(4);
        assertIterableEquals(List.of(1,2,3), list);
        list.removeByValue(3);
        assertIterableEquals(List.of(1,2), list);
        list.removeByValue(2);
        assertIterableEquals(List.of(1), list);
        list.removeByValue(1);
        assertIterableEquals(List.of(), list);
    }
    private DoublyCircularLinkedListSentinel getList() {
        DoublyCircularLinkedListSentinel list = new DoublyCircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        return list;
    }
}