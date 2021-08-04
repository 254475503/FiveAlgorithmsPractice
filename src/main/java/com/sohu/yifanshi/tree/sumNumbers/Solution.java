package com.sohu.yifanshi.tree.sumNumbers;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 * 1
 *2 3
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static int result = 0;
    public int sumNumbers(TreeNode root) {
        handle(root,0);
        return result;
    }
    public void handle(TreeNode node,int multiply){
        if(node==null)
            return;
        int temp = node.val+multiply*10;
        if(node.left==null&&node.right==null){
            result+=temp;
        }else {
            handle(node.left,temp);
            handle(node.right,temp);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node1.left = node3;
        node1.right = node2;
        node3.left = node4;
        node3.right = node5;
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(node1));
    }
}
