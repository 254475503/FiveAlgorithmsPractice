package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

public class IsSubTree {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        return (A != null && B != null)&&(recursive(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    public boolean recursive(TreeNode A,TreeNode B)
    {
        if(A==null&&B!=null)
            return false;
        if(B==null)
            return true;
        if(A.val!=B.val)
            return false;
        return recursive(A.left,B.left)&&(recursive(A.right,B.right));
    }
}
