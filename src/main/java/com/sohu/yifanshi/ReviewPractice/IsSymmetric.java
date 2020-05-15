package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        IsSymmetric is  = new IsSymmetric();
        System.out.println(is.isSymmetric(treeNode));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        int exist =0;
        int validsize = 0;
        if(root.left!=null)
        {
            exist++;
            validsize++;
            queue.add(root.left);
        }
        else {
            exist++;
            queue.add(new TreeNode(-1));
        }
        if(root.right!=null)
        {
            exist++;
            validsize++;
            queue.add(root.right);
        }
        else
        {
            exist++;
            queue.add(new TreeNode(-1));
        }

        while(validsize!=0)
        {
            List<Integer> valuelist = new ArrayList<>(exist);
            while (exist>0)
            {
                TreeNode tempnode = queue.poll();
                valuelist.add(tempnode.val);
                if(tempnode.left!=null)
                {
                    queue.add(tempnode.left);
                    validsize++;
                }
                else
                    queue.add(new TreeNode(-1));
                if(tempnode.right!=null)
                {
                    queue.add(tempnode.right);
                    validsize++;
                }
                else
                    queue.add(new TreeNode(-1));
                if(tempnode.val!=-1)
                    validsize--;
                exist--;
            }
            exist = queue.size();
            if(valuelist.size()!=0)
            {
                if(!isMirrorList(valuelist))
                    return false;
            }

        }
        return true;

    }


    public boolean isMirrorList(List<Integer> valuelist)
    {
        if((valuelist.size()&1)==1)
            return false;
        int i = 0;
        int j = valuelist.size()-1;
        while (i<j)
        {
            if(valuelist.get(i)!=valuelist.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


}
