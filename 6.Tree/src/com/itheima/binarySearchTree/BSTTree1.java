package com.itheima.binarySearchTree;
//Binary Search Tree-二叉搜索树
public class BSTTree1 {
    BSTNode root;  //根节点
    //节点类
    static class BSTNode{
        int key;  //因为要根据对应的键查找值
        Object value;//因为要根据对应的键查找值
        BSTNode left;
        BSTNode right;
        public BSTNode(int key){
            this.key = key;
        }
        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    //查找关键字对应的值：params:key-关键字；returns:关键字对应的值
/*    public Object get(int key){
        return doGet(root,key);   //尾递归，因为java不支持尾递归优化，所以当看到尾递归时考虑改成循环
    }
    private Object doGet(BSTNode node,int key){
        if(node == null){
            return null; //如果找到最后，node== null,则是没找到
        }
        if(key<node.key){
            return doGet(node.left,key);
        }else if(key > node.key){
            return doGet(node.right,key);
        }else {
            return node.value; //找到了
        }
    }*/
    //用非递归的方式实现get()
    public Object get(int key){
        BSTNode node = root;
        while(node != null){
            if(key < node.key){
                node = node.left;
            }else if(key > node.key){
                node = node.right;
            }else{
                return node.value;
            }
        }
        return null;
    }
    //用非递归的方式实现min()
    public Object min(){
        if(root == null){
            return null;
        }
        BSTNode p = root;
        while(p.left != null){
            p = p.left;
        }
        return p.value;
    }
    //查找最小关键字对应的值：returns:关键字对应的值
/*    public Object min(){

        return doMin(root);
    }
    public Object doMin(BSTNode node){
        if(node == null){
            return null;
        }
        if(node.left == null){ //最小的节点
            return node.value;
        }
        return doMin(node.left);
    }*/
    //查找最大关键字对应的值：returns:关键字对应的值
    public Object max(){
        if(root == null){
            return null;
        }
        BSTNode p = root;
        while(p.right != null){
            p = p.right;
        }
        return p.value;
    }
    //存储关键字和对应值：params:key-关键字；value:值
    public void put(int key,Object value){
        //1.key有则更新；2.key没有则新增
        BSTNode node = root;
        BSTNode parent =null;

        while(node != null){
            parent = node;
            if(key < node.key){
                node = node.left;
            }else if(key > node.key){
                node = node.right;
            }else{
                node.value = value; // 1.更新
                return;
            }
        }
        //while循环完，parent就是要插入的节点的父节点
        //2.新增
        if(parent == null){
            root = new BSTNode(key,value);
            return;
        }
        if(key<parent.key){
            parent.left = new BSTNode(key,value);
        }else{
            parent.right = new BSTNode(key,value);
        }
    }
    //查找关键字的前驱值：params：key-键；returns:前驱值
    public Object successor(int key){
        return null;
    }
    ///查找关键字的后继值：params：key-键；returns:后继值
    public Object predecessor(int key){
        return null;
    }
    //根据关键字删除：params：key-键；returns：被删除关键字对应值
    public Object delete(int key){
        return null;
    }


}
