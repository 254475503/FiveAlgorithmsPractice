package com.sohu.yifanshi.tree.binaryTreePaths;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        recur(root,"");
        return result;
    }

    public void recur(TreeNode root,String str){
        if(root==null)
            return;
        String nextStr = str+root.val;
        if(root.left==null&&root.right==null){
            result.add(nextStr);
            return;
        }
        nextStr +="->";
        recur(root.left,nextStr);
        recur(root.right,nextStr);
    }
}
