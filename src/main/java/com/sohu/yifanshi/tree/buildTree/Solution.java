package com.sohu.yifanshi.tree.buildTree;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

import javax.print.DocFlavor;
import java.util.Arrays;

public class Solution {
    //前序+中序
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length == 0)
            return null;
        else if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        TreeNode rootNode = new TreeNode(preorder[0]);
        int rootVal = rootNode.val;
        int rootIndex = 0;
        for(int i = 0 ; i < inorder.length ; i ++){
            if(rootVal==inorder[i]){
                rootIndex = i;
            }
        }
        TreeNode left = buildTree(Arrays.copyOfRange(preorder,1,rootIndex+1),Arrays.copyOfRange(inorder,0,rootIndex));
        TreeNode right = buildTree(Arrays.copyOfRange(preorder,rootIndex+1,preorder.length),Arrays.copyOfRange(inorder,rootIndex+1,inorder.length));
        rootNode.left = left;
        rootNode.right = right;
        return rootNode;
    }

    //中序+后序，第三个参数没用的。只是不想建两个类罢了- - 你就当它递归自己吧，懂我意思就行。。
    public TreeNode buildTree(int[] inorder, int[] postorder,TreeNode node){
        if(postorder==null||postorder.length == 0)
            return null;
        else if(postorder.length == 1){
            return new TreeNode(postorder[0]);
        }
        TreeNode rootNode = new TreeNode(postorder[postorder.length-1]);
        int rootVal = rootNode.val;
        int rootIndex = 0;
        for(int i = 0 ; i < inorder.length ; i ++){
            if(rootVal==inorder[i]){
                rootIndex = i;
            }
        }//0 1 2 3 4
        TreeNode left = buildTree(Arrays.copyOfRange(inorder,0,rootIndex),Arrays.copyOfRange(postorder,0,rootIndex));
        TreeNode right = buildTree(Arrays.copyOfRange(inorder,rootIndex+1,inorder.length),Arrays.copyOfRange(postorder,rootIndex,postorder.length-1));
        rootNode.left = left;
        rootNode.right = right;
        return rootNode;
    }

    public static void main(String[] args) {
        int[] i = new int[]{1,2,3};
        int[] j = Arrays.copyOfRange(i,0,0);
        System.out.println(j.length);
    }
}
