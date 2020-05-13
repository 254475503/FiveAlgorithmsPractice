package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

public class DoMirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode resultTree = new TreeNode(root.val);
        mirrorTree(root,resultTree);
        return resultTree;
    }
    public void mirrorTree(TreeNode sourceTree,TreeNode resultTree)
    {
        if(sourceTree==null)
        {
            return;
        }
        if(sourceTree.left!=null)
        {
            resultTree.right = new TreeNode(sourceTree.left.val);
            mirrorTree(sourceTree.left,resultTree.right);
        }
        if(sourceTree.right!=null)
        {
            resultTree.left = new TreeNode(sourceTree.right.val);
            mirrorTree(sourceTree.right,resultTree.left);
        }
        return;

    }
}
