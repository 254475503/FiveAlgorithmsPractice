package com.sohu.yifanshi.tree.levelOrder;

import com.sohu.yifanshi.standarddatastructure.TreeNode;
import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.bcel.internal.generic.FADD;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution {
    private static Queue<TreeNode> queue = new LinkedBlockingQueue<>();
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        Solution solution = new Solution();
        List<List<Integer>> asd = solution.levelOrder(treeNode1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        int temp = 1;
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> vals = new ArrayList<>();
            int i = temp;
            temp = 0;
            while (i!=0){
                TreeNode outQueueNode = queue.poll();
                vals.add(outQueueNode.val);
                if(outQueueNode.left!=null){
                    queue.add(outQueueNode.left);
                    temp++;
                }
                if(outQueueNode.right!=null){
                    queue.add(outQueueNode.right);
                    temp++;
                }
                i--;
            }
            result.add(vals);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root == null)
            return new ArrayList<>();
        Deque<TreeNode> deque = new LinkedBlockingDeque<>();
        int temp = 1;
        deque.add(root);
        boolean fromRight = true;
        List<List<Integer>> result = new ArrayList<>();
        while (!deque.isEmpty()){
            List<Integer> vals = new ArrayList<>();
            int i = temp;
            temp = 0;
            while (i!=0){
                TreeNode outQueueNode = null;
                if(fromRight){
                    outQueueNode = deque.pollFirst();
                    if(outQueueNode.left!=null){
                        deque.addLast(outQueueNode.left);
                        temp++;
                    }
                    if(outQueueNode.right!=null){
                        deque.addLast(outQueueNode.right);
                        temp++;
                    }
                }else {
                    outQueueNode = deque.pollLast();
                    if(outQueueNode.right!=null){
                        deque.addFirst(outQueueNode.right);
                        temp++;
                    }
                    if(outQueueNode.left!=null){
                        deque.addFirst(outQueueNode.left);
                        temp++;
                    }

                }

                vals.add(outQueueNode.val);

                i--;
            }
            result.add(vals);
            fromRight = !fromRight;
        }
        return result;
    }
}
