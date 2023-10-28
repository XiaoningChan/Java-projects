package com.itheima.binarySearchTree;

import static org.junit.jupiter.api.Assertions.*;

class BSTTree1Test {

    public BSTTree1 createTree(){
        /*                  4
                          /   \
                         2     6
                        / \   / \
                       1   3 5   7
        * */
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1,"张无忌");
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3,"宋青书");
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2,"周芷若",n1,n3);
        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5,"说不得");
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7,"殷离");
        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6,"赵敏",n5,n7);
        BSTTree1.BSTNode root = new BSTTree1.BSTNode(4,"小昭",n2,n6);
        BSTTree1 tree = new BSTTree1();
        tree.root = root;
        return tree;
    }
    @org.junit.jupiter.api.Test
    void get() {
        assertEquals("张无忌",createTree().get(1));
        assertEquals("周芷若",createTree().get(2));
        assertEquals("宋青书",createTree().get(3));
        assertEquals("小昭",createTree().get(4));
        assertEquals("说不得",createTree().get(5));
        assertEquals("赵敏",createTree().get(6));
        assertEquals("殷离",createTree().get(7));
        assertNull(createTree().get(8));
    }
    @org.junit.jupiter.api.Test
    void minMav(){
        BSTTree1 tree = createTree();
        assertEquals("张无忌",tree.min());
        assertEquals("殷离",tree.max());
    }
    @org.junit.jupiter.api.Test
    void put(){
        BSTTree1 tree = new BSTTree1();
        tree.put(4,new Object());
        tree.put(2,new Object());
        tree.put(6,new Object());
        tree.put(1,new Object());
        tree.put(3,new Object());
        tree.put(7,new Object());
        tree.put(5,new Object());
        assertTrue(isSameTree(createTree().root,tree.root));
        tree.put(1,"张无忌");
        assertEquals("张无忌",tree.get(1));

    }
    static boolean isSameTree(BSTTree1.BSTNode tree1,BSTTree1.BSTNode tree2){
        if(tree1 == null && tree2 == null){
            return true;
        }
        if(tree1 == null || tree2 == null){
            return false;
        }
        return tree1.key == tree2.key;
    }

}