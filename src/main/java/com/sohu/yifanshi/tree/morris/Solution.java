package com.sohu.yifanshi.tree.morris;

import com.sohu.yifanshi.standarddatastructure.TreeNode;

/**
 * 二叉树的morris遍历，只需要o（1）的额外空间。
 * 遍历过程有两个指针
 * 一个指针current，指向正在遍历的节点，第二个指针mostRight指向current指针左子树的最右子节点（可以是左子树根结点本身）
 * 1.current左节点为null，则current右移
 * 2.current左节点不为null，则将current左子树的最右节点，（没错就是你想的那样，current.left的一直right就完事儿，一直到最后一个不为null的节点）设置为mostRight
 * 2.1 如果mostRight的右指针指向null，则把mostRight.right指向current，随后current左移
 * 2.2 如果mostRight的右指针指向current，则把mostRight.right指向null，随后current右移
 * 这种遍历的特点是，有左子树的节点，会被遍历两次，没有的话只会被遍历一次，而且没有用到更多额外的空间，只用了两个指针，current与rightMost
 */
public class Solution {
    public void morrisTraversal(TreeNode treeNode){
        if(treeNode == null)
            return;
        TreeNode current,mostRight;
        current = treeNode;
        while (current!=null){
            if(treeNode.left==null){//current的left指针为空，current右移
                current = treeNode.right;
            }else {
                mostRight = current.left;
                while (mostRight.right!=null&&mostRight.right!=current){
                    mostRight = mostRight.right;//找current左子树的最右节点设置为mostRight
                }
                if(mostRight.right==null) {//如果mostRight右节点为空，则设置为current，之后current左移
                    mostRight.right = current;
                    current = current.left;
                }else {//如果不为空，则肯定为current了，那么将其置为空，同时current右移
                    mostRight.right = null;
                    current = current.right;
                }
            }
        }

    }

}
