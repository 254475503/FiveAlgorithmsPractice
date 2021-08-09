package com.sohu.yifanshi.tree.lowestCommonAncestor;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private TreeNode result;
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        while (result!=null){
            if(result.val>p.val&&result.val>q.val){
                result = result.left;
            }else if(result.val<p.val&&result.val<q.val){
                result = result.right;
            }else {
                break;
            }
        }
        return result;
    }*/


    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 看题解会的。。理解并背诵把
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return result;
    }

    /**
     * dfs方法是递归的返回该root节点下是否包含p或q节点。
     * 如果某个root节点满足一下2中情况之1，那么root节点就是最深的公共祖先
     * 1。root节点的左子树与右子树，分别拥有p，q节点其中之1
     * 2。root节点就是p,q节点中的一个，且他的左子树或者右子树中包含p，q节点中剩下的一个节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return false;
        }
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        if((lson&&rson)||((root.val==p.val||root.val==q.val)&&(lson||rson))) {//判断root是否满足这两个条件中的1个
            result = root;
        }
        return lson||rson||root.val==q.val||root.val==p.val;//root是p或q或者他的左右子树中包含了至少1个，p或q，那么都是该root节点包含p，q节点中的一个，返回true/
    }

}
