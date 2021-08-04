package com.sohu.yifanshi.tree.pathSum;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private static List<List<Integer>> resultList = new ArrayList<>();
    private static ArrayList<Integer> tempList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        resultList.clear();
        tempList.clear();
        recur(root,sum);
        return resultList;
    }
    public void recur(TreeNode root,int sum)
    {
        if(root==null)
            return;
        tempList.add(root.val);
        sum-=root.val;
        if(sum==0&&root.left==null&&root.right==null)
        {
            resultList.add((List<Integer>) tempList.clone());
            tempList.remove(tempList.size()-1);
            return;
        }
        recur(root.left,sum);
        recur(root.right,sum);
        tempList.remove(tempList.size()-1);
        return;
    }
}
