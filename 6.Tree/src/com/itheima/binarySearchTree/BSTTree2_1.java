package com.itheima.binarySearchTree;
//为提高扩展性，可将value也改为泛型
public class BSTTree2_1<k extends Comparable<k>,v> {
    BSTNode<k,v> root;
    static class BSTNode<k,v>{
        k key;  //因为要根据对应的键查找值
        v value;//因为要根据对应的键查找值
        BSTNode<k,v> left;
        BSTNode<k,v> right;
        public BSTNode(k key){
            this.key = key;
        }
        public BSTNode(k key, v value) {
            this.key = key;
            this.value = value;
        }
        public BSTNode(k key, v value, BSTNode<k,v> left, BSTNode<k,v> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public v get(k key){
        BSTNode<k,v> p = root;
        while(p != null){
            int result = key.compareTo(p.key);//result = -1 if key<p.key;0 if key=p.key;1 if key>p.key
            if(result<0){
                p = p.left;
            }else if(result > 0){
                p = p.right;
            }else{
                return p.value;
            }
        }
        return null;
    }
}
