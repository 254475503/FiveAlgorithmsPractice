package com.sohu.yifanshi.test.depthOf2Tree;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class depthOf2Tree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode5;
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode2;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;
        boolean flag = true;
        System.out.println(getDepthOfTree(treeNode4));
        System.out.println(getDepthOf2Tree(treeNode4,flag) + "is balanced?:" + flag);
    }
    public static int getDepthOf2Tree(TreeNode root,Boolean flag)
    {//获取二叉树的深度，二叉树的深度我们以根节点来看。就是根节点的左右子树深度大的哪一个加上1就是二叉树的深度。那么左右子树的深度又是怎么来的？也是一样
        //的，由他们的子树深度大的哪一个加上1即可。就这样一直递归就行了。
        if(root == null)
            return 0;
        int leftDepth = getDepthOf2Tree(root.left,flag);
        int rightDepth = getDepthOf2Tree(root.right,flag);
        if(leftDepth-rightDepth>1||rightDepth-leftDepth>1)
            flag = false;
        return leftDepth>rightDepth ? leftDepth+1 :rightDepth+1;
    }

    //二叉树深度的迭代算法
    public static int getDepthOfTree(TreeNode root)
    {
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<TreeNode>();
        TreeNode pointer = root;
        treeNodeQueue.add(root);
        int depth = 0;
        while (!treeNodeQueue.isEmpty())
        {
            depth++;
            int size = treeNodeQueue.size();
            while (size!=0){//迭代的算法难以解决的点就是，我们难以确定再这个队列中出队出到什么时候一层就已经出完了。这样就对我们记深度造成了困难。
                //这个算法将每一层的操作分开了。第一次进循环，只有根节点在队列中，队列的长度为1。所以要将第一层全部出队，我们就要循环出队1次。
                //第一层循环出队完毕，队列就只剩下第二层的节点了。此时 的 队列的长度也代表了第二层的节点数目，我们只要循环出对队列长度次，就能将第二层
                //出队完毕只剩下第三层的节点，计算深度的时机就应该是每次循环出队将某一层的节点出队完毕时进行深度的自增。这样就能迭代的计算二叉树的深度。
                pointer = treeNodeQueue.poll();
                if(pointer.right!=null)
                    treeNodeQueue.add(pointer.right);
                if(pointer.left!=null)
                    treeNodeQueue.add(pointer.left);
                size--;
            }//这个函数稍微改以下就能改成算出二叉树宽度的算法（二叉树宽度为各层节点的最大值。）只要记录选最大的size
            //（size对应的是每一层的节点数），最大的size就是宽度了。

        }
        return depth;
    }

}
