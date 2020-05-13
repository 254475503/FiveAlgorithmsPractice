package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
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
        if(root==null||sum<0)
            return;
        tempList.add(root.val);
        sum-=root.val;
        if(sum==0)
        {
            resultList.add((List<Integer>) tempList.clone());
            return;
        }
        recur(root.left,sum);
        recur(root.right,sum);
        tempList.remove(tempList.size()-1);
        return;
    }
}
