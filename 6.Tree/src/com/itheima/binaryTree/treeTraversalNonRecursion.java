package com.itheima.binaryTree;

public class treeTraversalNonRecursion {
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
//        LinkedListStack<TreeNode> Stack = new LinkedListStack<>//范型
//        TreeNode curr = root;//代表当前节点
//        while(curr != null){
//            if(curr != null){
//                System.out.println("去："+curr.val);
//                stack.push(curr);//压入栈，为了记住来时的路
//                curr = curr.left;
//            }else{
//                TreeNode pop = stack.pop();
//                System.out.println("回"+pop.val);
//                curr = pop.right;
//            }
//        }
    }
}
