package com.itheima.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class insertionSortTest {

    @Test
    public void test1() {
        int[] expected = {1,2,3,4,5};
        int[] a1 = {5,4,3,2,1};
        insertionSort.sort(a1);
        assertArrayEquals(expected,a1);
    }
}