package com.itheima.binarySearchTree;
//二叉搜索树，泛型key版本
//因为要保证泛型T是可以比较的，所以需要限制T是可比较的，让它继承Comparable<T>接口，是Comparable<T>的子类
public class BSTTree2<T extends Comparable<T>> {
    BSTNode<T> root;
    static class BSTNode<T>{
        T key;  //因为要根据对应的键查找值
        Object value;//因为要根据对应的键查找值
        BSTNode<T> left;
        BSTNode<T> right;
        public BSTNode(T key){
            this.key = key;
        }
        public BSTNode(T key, Object value) {
            this.key = key;
            this.value = value;
        }
        public BSTNode(T key, Object value, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public Object get(T key){
        BSTNode<T> p = root;
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
    //为提高扩展性，可将value也改为泛型


}
