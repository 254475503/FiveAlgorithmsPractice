package com.sohu.yifanshi.test.inOrderTravelSal;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SeqTraverse {//树的层序遍历
    public void Solution(TreeNode treeNode)
    {
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
        queue.add(treeNode);
        TreeNode temp = queue.poll();
        while (temp!=null)
        {
            System.out.println(temp.val);
            if(temp.left!=null)queue.add(temp.left);
            if(temp.right!=null)queue.add(temp.right);
            temp = queue.poll();
        }
    }
}
