package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

public class IsSymmertic {

        public boolean isSymmetric(TreeNode root) {
            if(root==null)
                return true;
            return istwoTreeMirror(root.left,root.right);
        }

        public boolean istwoTreeMirror(TreeNode left,TreeNode right)
        {
            if(null==left&&null==right)
                return true;
            else if(left!=null&&right!=null)
            {
                if(left.val == right.val)
                {
                    return istwoTreeMirror(left.right,right.left)&&istwoTreeMirror(left.left,right.right);
                }else {
                    return false;
                }
            }

            else
                return false;
        }
}
