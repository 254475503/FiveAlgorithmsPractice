package com.sohu.yifanshi.tree.BSTkthSmallest;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

public class Solution {
    public static int i = 0;
    public static int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(i==k||root==null)
            return result;
        kthSmallest(root.left,k);
        i++;
        if(i==k)
            result = root.val;
        kthSmallest(root.right,k);
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode2.left = treeNode1;
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(treeNode5,3));
    }
}
