package com.sohu.yifanshi.tree.BSTIterator;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BSTIterator {
    private TreeNode root;
    private Stack<TreeNode> stack ;
    public BSTIterator(TreeNode root) {
        root = root;
        stack = new Stack<>();
        popIn(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if(node!=null){
            popIn(node.right);
            return node.val;
        }
        return 0;

    }
    public void popIn(TreeNode node){
        TreeNode temp = node;
        while (temp!=null){
            stack.push(temp);
            temp = temp.left;
        }
    }


    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
