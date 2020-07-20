package com.sohu.yifanshi.test.SortedArrayToBST;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       return buildBST(0,nums.length-1,nums);
    }

    private TreeNode buildBST(int low, int high, int[] nums) {
        if(low>high)
            return null;
        if(low ==high)
            return new TreeNode(nums[low]);
        int middle = (low+high)>>1;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = buildBST(low,middle-1,nums);
        treeNode.right = buildBST(middle+1,high,nums);
        return  treeNode;
    }
}
