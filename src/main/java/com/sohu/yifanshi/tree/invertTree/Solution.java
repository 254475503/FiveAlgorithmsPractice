package com.sohu.yifanshi.tree.invertTree;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
