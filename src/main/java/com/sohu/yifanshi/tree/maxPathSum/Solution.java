package com.sohu.yifanshi.tree.maxPathSum;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *  
 *
 * 示例 1：
 *     1
 *  2     3
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 这次写的不知道为啥过不去，我本地运行的没问题，leetcode上运行的只放一个0节点上去结果是42？？
 * 思路很简单。
 * 用的dp的思路，假设一个节点既有左子树又有右子树的情况下，他的路径会有四种情况，自己的值，自己值+左子树作为路径最大值，自己值+右子树作为路径最大值，自己值+左+右。
 * 这四种情况中的最大值，就是这个节点作为最终路径的最大值，但是这个节点如果要作为自己父节点的其中一条路径，那么他就不能左右值全家。
 * 所以递归的时候，考虑某个节点的4种情况中的最大值，作为可能的最大值，用全局的一个变量去存储比较，然后在把这个节点作为路径的最大值，返回给父节点，就这样一直递归就好了。
 */
public class Solution {
    public static int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         handlePath(root);
         return maxSum;
    }

    public int handlePath(TreeNode root){
        int result ;
        if(root==null){
            return 0;
        }else {
            result = root.val;
        }
        int left = handlePath(root.left);
        int right = handlePath(root.right);
        result = left>right?result+left:result+right;
        if(root.val>result){
            result = root.val;
        }
        int tempMaxSum = root.val+left+right;
        if(tempMaxSum<result){
            tempMaxSum = result;
        }
        if(maxSum<tempMaxSum)
            maxSum = tempMaxSum;
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(treeNode));
    }
}
