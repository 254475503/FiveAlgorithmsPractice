package com.sohu.yifanshi.test.inOrderTravelSal;

public class NumsOfTreeNode
{
    public int Solution(TreeNode treeNode)
    {
        if(treeNode==null)
            return 0;
        return Solution(treeNode.left)+Solution(treeNode.right)+1;
    }
}
