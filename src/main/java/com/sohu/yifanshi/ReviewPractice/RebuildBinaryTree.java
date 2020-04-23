package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import java.util.Hashtable;
import java.util.Stack;

public class RebuildBinaryTree {

    public static   int fib(int n) {
        Hashtable<Integer,Integer> table = new Hashtable();

        table.put(0,0);
        table.put(1,1);
        return calFib(n,table);
    }
    public static    int calFib(int n,Hashtable<Integer,Integer> table)
    {
        Integer result = table.get(n);
        if(result==null)
        {
            result = calFib(n-1,table)+calFib(n-2,table);
            table.put(n,result);
        }
        return result;
    }
    public static void main(String[] args) {

        System.out.println(fib(10));
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

       return buildRootNode(preorder,inorder,0,0,preorder.length-1);

    }

    public static TreeNode buildRootNode(int[] preorder,int[] inorder,int rootNodeIndex,int startIndex,int endIndex)
    {
        TreeNode rootNode =new TreeNode(preorder[rootNodeIndex]);
        int i = startIndex;
        for(;i<=endIndex;i++)
        {
            if(inorder[i]==rootNode.val)
                break;
        }
        if(i!=startIndex)
        {
            rootNode.left = buildRootNode(preorder,inorder,rootNodeIndex+1,startIndex,i-1);
        }
        if(i!=endIndex)
        {
            rootNode.right = buildRootNode(preorder,inorder,(rootNodeIndex+1)+(i-1-startIndex)+1,i+1,endIndex);
        }
        return rootNode;
    }
}
