package com.itheima.binarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTree2Test {
    public BSTTree2<String> createTree(){
        /*                  4
                          /   \
                         2     6
                        / \   / \
                       1   3 5   7
        * */
        BSTTree2.BSTNode<String> n1 = new BSTTree2.BSTNode<>("a","张无忌");
        BSTTree2.BSTNode<String> n3 = new BSTTree2.BSTNode<>("c","宋青书");
        BSTTree2.BSTNode<String> n2 = new BSTTree2.BSTNode<>("b","周芷若",n1,n3);
        BSTTree2.BSTNode<String> n5 = new BSTTree2.BSTNode<>("e","说不得");
        BSTTree2.BSTNode<String> n7 = new BSTTree2.BSTNode<>("g","殷离");
        BSTTree2.BSTNode<String> n6 = new BSTTree2.BSTNode<>("f","赵敏",n5,n7);
        BSTTree2.BSTNode<String> root = new BSTTree2.BSTNode<>("d","小昭",n2,n6);
        BSTTree2<String> tree = new BSTTree2<>();
        tree.root = root;
        return tree;
    }

    @Test
    void get() {
        assertEquals("张无忌",createTree().get("a"));
        assertEquals("周芷若",createTree().get("b"));
        assertEquals("宋青书",createTree().get("c"));
        assertEquals("小昭",createTree().get("d"));
        assertEquals("说不得",createTree().get("e"));
        assertEquals("赵敏",createTree().get("f"));
        assertEquals("殷离",createTree().get("g"));
        assertNull(createTree().get("h"));
    }
}