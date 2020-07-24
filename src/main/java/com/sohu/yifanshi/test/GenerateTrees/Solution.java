package com.sohu.yifanshi.test.GenerateTrees;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class Solution {//第95题 不同的二叉搜索树
    private List<List<TreeNode>> dp ;
    public static void main(String[] args) {
        Solution solution  = new Solution();
       List<TreeNode> result =  solution.generateTrees(1);
        System.out.println("finish");
    }
    public List<TreeNode> generateTreesDp(int n)
    {
        if(n==0)
            return new LinkedList<>();
        this.dp = new LinkedList<List<TreeNode>>();
        dp.add(0,new LinkedList<TreeNode>(){{add(null);}});
        dp.add(1,new LinkedList<TreeNode>(){{add(new TreeNode(1));}});
        for(int i = 2 ; i<=n ; i++)
        {
            List<TreeNode> dptemp = new LinkedList<>();
            for(int j = 1; j <= i ; j++)
            {
                for(TreeNode leftNode : dp.get(j-1))
                {
                    for(TreeNode rightNode :dp.get(i-j))
                    {
                        TreeNode treeNode = new TreeNode(j);
                        treeNode.left = leftNode;
                        treeNode.right = cloneTree(rightNode,j);
                        dptemp.add(treeNode);
                    }
                }

            }
            dp.add(i,dptemp);
        }
        return dp.get(n);
    }

    public TreeNode cloneTree(TreeNode originTree,int offset){
        if(originTree==null)
            return null;
        TreeNode newNode = new TreeNode(originTree.val+offset);
        newNode.left = cloneTree(originTree.left,offset);
        newNode.right = cloneTree(originTree.right,offset);
        return newNode;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
        {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start,int end)
    {
        List<TreeNode> result = new LinkedList<>();
        if(start>end)
        {
            result.add(null);
            return result;
        }
        for(int i = start; i <= end ; i++){
            List<TreeNode> leftTreeNode = generateTrees(start,i-1);
            List<TreeNode> rightTreeNode = generateTrees(i+1,end);
            for(TreeNode leftNode : leftTreeNode)
            {
                for(TreeNode rightNode : rightTreeNode)
                {
                    TreeNode rootNode = new TreeNode(i);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                    result.add(rootNode);
                }
            }
        }
        return result;

    }
}
