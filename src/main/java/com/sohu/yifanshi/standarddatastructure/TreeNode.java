package com.sohu.yifanshi.standarddatastructure;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}

    public TreeNode(int val){this.val = val;}

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
