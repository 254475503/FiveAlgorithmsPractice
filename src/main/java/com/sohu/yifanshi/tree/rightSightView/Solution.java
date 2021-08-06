package com.sohu.yifanshi.tree.rightSightView;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *
 *
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 */
public class Solution {
    public static List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        recur(root,0);
        return result;
    }
    public void recur(TreeNode root,int depth){
        if(result.size()==depth){
            result.add(root.val);
        }
        if(root.right!=null){
            recur(root.right,depth+1);
        }else {
            if(root.left!=null){
                recur(root.left,depth+1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.right = right;
        List<Integer> array = solution.rightSideView(root);
        for(Integer num : array){
            System.out.println(num);
        }
    }
}
