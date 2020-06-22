package com.sohu.yifanshi.test.MaxBinaryTreeSum;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import javax.smartcardio.TerminalFactory;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.left = treeNode;
        treeNode2.right = treeNode1;
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(treeNode2));
    }
    private int max =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode node)
    {
        if(node ==null)
            return 0;
        else {
            int leftmax = maxSum(node.left);
            int rightmax = maxSum(node.right);
            int sub = Math.max(leftmax,rightmax);
            int result = sub>0?sub+node.val:node.val;
            int mayMax = node.val;
            if(leftmax>0)
                mayMax +=leftmax;
            if(rightmax>0)
                mayMax +=rightmax;

            if(mayMax>max)
                max = mayMax;
            return result;
        }
    }
}
