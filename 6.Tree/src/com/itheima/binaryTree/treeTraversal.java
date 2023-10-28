package com.itheima.binaryTree;
//树节点类
public class treeTraversal {
    public static void main(String[] args) {
        /**
                 1
               /   \
              2     3
             /    /   \
            4    5     6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),2,null),
                1,
                new TreeNode(new TreeNode(5),3,new TreeNode(6))
        );
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();

    }
    //1.前序遍历：Params:node-节点
    static void preorder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val+"\t"); //根节点值
        preorder(node.left);//左
        preorder(node.right);//右
    }
    //2.中序遍历：Params:node-节点
    static void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);//左
        System.out.println(node.val+"\t");//值
        inorder(node.right);//右
    }
    //3.后序遍历：Params:node-节点
    static void postorder(TreeNode node){
        if(node == null){
            return;
        }
        postorder(node.left);//左
        postorder(node.right);//右
        System.out.println(node.val+"\t");//值
    }

}
