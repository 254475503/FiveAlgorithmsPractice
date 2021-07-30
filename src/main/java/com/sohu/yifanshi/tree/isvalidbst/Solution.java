package com.sohu.yifanshi.tree.isvalidbst;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

public class Solution {
    public static int temp = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(isValidBST(root.left)){
            if(root.val>temp)
                temp = root.val;
            else
                return false;
        }else
            return false;
        return isValidBST(root.right);

    }
}
