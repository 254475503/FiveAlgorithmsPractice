package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeBinaryTree {
    int start = 0;

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode33 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode5.left = treeNode2;
        treeNode5.right = treeNode3;
        treeNode3.left = treeNode22;
        treeNode3.right = treeNode4;
        treeNode22.left = treeNode33;
        treeNode22.right = treeNode1;
        SerializeBinaryTree sbt = new SerializeBinaryTree();
        System.out.println(sbt.serialize(treeNode5));
        String str = "\"[123]\"";
        str = str.replaceAll("\\]\"", "");
        str = str.replaceAll("\"\\[", "");
        System.out.println(str);
        long time1 = System.currentTimeMillis();
        //TreeNode treeNode = sbt.deserialize("\"[7,3,6,8,2,3,6,4,7,6,5,1,null,3,null,8,7,9,9,6,5,3,3,0,null,0,0,0,null,1,6,2,6,7,0,9,null,8,null,5,2,2,6,3,null,3,2,9,0,5,2,null,8,7,0,8,null,6,9,8,5,9,1,9,0,8,8,0,5,null,5,1,8,8,0,3,3,4,6,7,null,1,null,null,null,8,3,0,6,2,null,6,8,null,9,5,8,5,0,6,6,1,7,0,8,9,7,2,1,5,8,6,9,1,null,6,null,null,4,7,0,6,9,3,3,9,2,1,3,7,7,9,9,1,5,5,null,3,4,4,6,3,2,6,1,4,0,4,4,4,9,7,2,8,6,6,null,1,9,2,6,1,1,null,8,6,1,1,7,7,6,7,1,0,4,1,3,4,4,null,null,4,1,8,7,5,6,null,2,5,6,9,7,null,8,6,7,null,9,8,9,9,9,1,null,7,null,7,7,8,0,8,5,1,null,2,6,7,9,5,2,8,null,2,null,7,5,5,null,2,null,0,7,null,null,null,5,5,9,9,null,0,1,null,5,null,5,6,5,null,1,3,9,null,1,9,0,6,8,7,2,1,4,4,7,7,8,0,8,3,7,7,8,7,3,7,6,7,5,5,9,7,null,9,9,1,3,2,2,5,6,2,4,3,null,5,null,5,3,1,null,0,6,0,8,6,1,1,3,4,3,0,8,7,null,null,6,null,null,2,7,0,null,2,null,1,6,7,6,3,null,null,0,5,5,0,7,3,6,5,3,2,5,null,9,2,7,0,5,null,9,1,5,null,3,1,7,null,6,5,3,5,null,6,5,5,9,0,0,2,6,3,9,3,2,3,0,4,null,7,0,5,1,7,5,4,2,null,5,8,9,9,0,9,9,6,8,2,0,null,1,null,0,null,1,5,3,8,1,6,3,8,null,0,8,null,3,9,5,1,6,4,7,8,0,8,7,9,9,2,null,3,6,1,0,6,4,1,7,6,null,9,5,7,1,2,6,null,2,null,0,9,null,8,8,3,7,0,3,5,3,8,4,7,2,3,7,5,7,3,5,6,2,7,7,null,0,5,7,4,1,null,0,null,6,0,7,null,2,4,7,8,6,1,0,9,1,9,4,3,2,0,null,4,9,4,1,7,5,8,null,9,0,2,null,4,3,1,2,4,2,6,2,5,1,null,0,0,7,8,9,7,6,null,null,3,null,7,2,0,5,8,null,2,null,0,5,1,1,4,1,2,5,8,9,2,5,0,null,2,8,null,null,2,4,0,6,4,null,8,0,6,8,2,null,4,4,0,2,0,9,6,2,null,null,6,0,2,9,5,9,7,0,9,3,null,8,5,5,null,4,1,5,8,3,3,7,null,8,null,8,null,9,4,null,2,7,2,8,8,6,7,5,3,9,6,4,0,null,5,0,8,7,8,null,5,9,6,null,6,6,5,2,3,9,8,1,2,0,2,1,null,8,8,null,8,4,null,1,null,0,0,1,8,7,7,9,8,9,null,7,1,null,7,9,3,9,null,7,3,7,null,8,1,2,8,3,4,null,5,7,0,6,7,1,null,null,1,null,8,4,3,6,0,9,null,2,3,0,3,8,null,6,null,null,7,2,7,9,null,4,9,4,null,8,null,3,4,6,0,0,2,8,1,5,0,7,1,3,0,4,4,5,3,0,0,2,1,5,5,1,3,8,3,null,6,8,1,2,null,0,9,2,null,null,8,8,null,4,9,6,9,8,8,5,1,5,0,6,6,0,9,null,5,null,4,2,null,9,0,4,7,7,1,null,null,null,5,9,8,null,null,5,5,8,null,9,7,0,0,2,4,0,1,3,5,8,null,9,7,6,8,6,0,1,9,9,4,3,3,0,5,null,null,7,8,5,null,9,6,1,6,7,2,7,3,5,8,4,4,8,null,7,null,3,8,0,2,8,8,2,1,8,4,1,null,null,7,1,0,0,7,5,6,null,0,7,null,0,null,4,8,4,null,null,6,2,0,null,5,4,8,3,null,3,6,8,2,5,6,null,1,1,4,1,null,7,2,8,7,6,5,null,9,7,9,1,4,null,4,9,null,3,1,null,null,9,7,null,0,8,4,4,8,2,7,0,0,4,7,1,null,9,2,4,5,null,5,4,4,3,9,8,1,3,3,1,0,4,5,8,6,0,0,null,null,1,1,0,9,3,0,4,null,2,1,9,1,4,0,5,2,0,null,1,1,8,7,9,8,2,9,2,7,5,3,3,6,7,null,2,0,9,5,9,null,6,null,6,3,1,3,0,0,8,0,2,4,3,2,9,7,null,2,2,2,null,2,4,9,2,0,null,5,null,3,7,0,1,3,3,8,4,0,9,3,2,6,null,5,9,5,6,3,3,2,0,4,3,0,0,5,null,7,null,4,1,1,9,null,null,0,4,5,7,2,6,8,8,null,null,2,3,8,2,2,3,2,7,2,2,null,2,9,0,9,0,6,6,1,5,null,null,8,8,9,7,5,0,6,null,9,4,8,0,2,7,5,1,4,8,5,9,3,6,0,5,3,null,0,3,0,5,8,7,2,3,6,8,6,9,0,4,6,1,3,1,3,2,3,5,6,3,8,7,3,3,6,5,1,2,2,9,4,3,3,0,4,null,4,4,2,null,null,7,null,5,2,2,1,0,3,null,1,2,3,0,6,2,7,2,9,5,9,1,3,5,8,9,null,5,0,5,1,null,2,7,0,8,4,6,null,2,2,8,5,null,4,5,8,8,7,9,0,8,9,9,0,4,8,6,3,8,5,0,1,1,0,8,4,7,null,1,null,6,2,2,9,9,8,2,3,5,6,4,8,null,null,4,null,1,6,2,3,null,3,null,7,5,null,9,2,0,7,4,2,0,7,0,2,9,1,1,8,0,3,9,7,0,0,2,5,9,null,3,null,null,4,9,null,0,5,0,6,8,0,0,9,0,3,1,null,7,7,0,0,9,1,7,8,2,null,6,9,1,0,1,8,1,9,8,8,8,5,6,3,5,7,0,7,7,9,6,null,null,1,8,null,2,7,6,7,4,6,4,1,2,2,1,2,1,null,7,8,7,null,3,1,5,null,3,9,1,3,5,3,7,7,3,null,0,2,4,9,3,7,7,5,null,0,0,null,5,0,7,6,2,8,2,null,4,null,2,7,null,null,7,3,4,1,7,8,2,6,4,7,8,7,8,3,4,9,3,6,9,6,5,9,0,6,5,4,9,4,2,7,1,1,2,0,5,2,9,null,5,6,1,7,0,7,null,9,7,9,9,null,null,8,1,2,2,9,9,3,7,null,2,0,3,null,null,6,5,null,7,null,0,4,1,3,null,6,7,4,0,5,1,null,8,null,8,2,1,2,3,2,9,8,3,null,3,4,1,5,1,7,3,null,4,3,5,7,9,4,2,null,1,4,3,null,9,7,null,2,null,1,2,2,3,8,8,3,1,5,1,null,6,1,5,5,0,null,1,null,8,9,3,8,7,5,4,0,9,9,5,null,4,null,null,1,0,1,0,3,null,0,7,1,2,5,4,2,1,3,9,null,null,null,1,5,6,4,null,3,0,4,0,1,3,6,null,0,6,5,null,2,null,7,null,null,null,null,1,3,4,7,5,null,null,0,3,8,0,null,3,1,7,3,null,2,9,9,1,null,9,null,4,5,null,7,0,null,5,9,2,6,2,4,3,0,3,0,7,3,7,4,4,1,9,3,2,3,7,2,null,6,8,1,2,0,0,1,6,5,5,6,7,4,7,8,6,2,8,8,6,4,5,8,4,0,5,3,1,null,1,9,6,null,null,9,3,6,8,3,5,0,null,6,5,8,null,1,null,9,2,5,1,5,1,null,8,null,null,6,3,6,4,1,null,2,1,2,9,8,4,3,2,5,null,0,5,6,null,null,2,1,6,4,4,9,1,9,9,3,6,3,3,0,5,7,0,7,2,4,0,9,6,5,null,1,0,4,9,3,4,4,0,null,9,2,0,7,3,8,0,8,3,4,6,null,7,8,2,7,3,1,9,3,3,4,4,null,3,4,null,null,8,8,9,9,null,5,null,1,5,7,0,9,6,1,8,8,7,7,null,null,0,3,0,null,8,4,5,0,9,5,7,null,5,0,8,7,8,0,2,4,4,3,9,0,8,4,3,4,3,8,6,2,1,5,null,null,0,2,4,0,6,5,2,8,7,2,9,1,7,null,5,0,null,null,null,7,4,1,5,8,6,null,7,0,3,8,2,9,8,1,null,0,7,null,2,null,8,7,6,5,1,1,7,9,7,3,7,null,5,null,2,4,6,8,null,0,4,5,8,null,7,5,9,1,null,null,5,8,5,0,null,null,1,1,0,2,0,4,5,3,3,8,0,4,null,2,3,8,null,9,5,4,4,6,5,4,7,2,0,1,null,4,8,9,0,7,8,2,8,0,5,4,6,2,8,5,2,6,7,5,9,0,4,null,6,9,2,0,2,6,null,null,null,7,2,2,7,0,9,null,9,9,null,1,6,null,3,9,1,9,6,5,0,0,3,8,6,2,0,2,null,7,null,8,1,3,7,null,1,null,6,9,3,6,8,2,8,4,3,6,6,8,null,3,1,1,8,3,0,9,6,null,5,7,5,null,9,2,1,7,3,7,3,null,3,2,null,2,null,4,4,9,0,1,8,5,5,1,7,5,3,0,8,5,3,6,6,5,null,3,6,7,8,null,0,1,6,5,null,5,7,3,1,2,6,3,null,6,1,7,4,9,3,3,1,1,8,4,6,null,1,2,0,null,7,9,4,6,0,7,3,4,7,3,0,1,9,6,8,2,7,null,null,7,1,2,1,0,8,8,8,2,0,3,7,3,1,8,null,5,3,2,8,7,8,null,null,8,9,9,7,null,null,7,4,7,4,null,7,7,9,3,null,3,0,6,0,5,7,2,2,6,4,3,null,7,0,6,9,9,5,2,3,6,7,null,8,2,null,6,null,8,4,1,2,0,3,null,4,9,7,3,9,4,8,6,0,0,null,5,null,2,0,3,1,9,0,8,8,null,9,8,8,7,2,0,5,4,4,5,0,2,2,6,8,5,3,5,8,9,8,6,9,4,7,4,3,2,4,1,9,9,0,2,9,null,null,4,3,null,null,5,7,1,6,3,5,9,null,1,null,2,4,9,1,8,3,2,null,7,7,3,8,5,1,3,5,9,null,8,8,2,6,9,0,2,5,1,7,6,0,2,0,7,6,null,0,3,9,6,9,5,6,1,null,3,7,null,6,2,3,4,9,5,4,null,null,1,null,4,7,5,9,null,4,0,4,7,4,1,6,7,7,0,5,1,8,1,3,2,3,4,3,2,9,8,2,8,2,0,8,6,1,4,9,9,9,7,5,8,0,6,4,3,0,null,null,4,4,null,null,5,null,5,1,0,5,null,8,5,null,null,6,1,1,0,7,8,2,8,7,8,9,8,null,6,7,9,1,0,3,7,null,null,3,0,2,1,8,1,3,6,9,1,null,6,null,7,7,5,6,1,8,0,2,1,5,1,5,null,7,6,null,2,4,null,5,1,0,8,7,3,9,7,7,6,7,null,2,9,7,0,8,5,9,3,3,null,6,2,2,5,0,null,1,5,5,6,3,1,4,2,null,8,9,3,7,3,6,6,5,6,0,9,4,5,4,3,3,3,null,7,7,null,8,null,5,8,9,1,9,0,4,9,7,2,8,3,6,3,1,8,null,3,3,1,8,8,5,3,2,0,7,5,6,9,2,3,1,4,9,9,0,null,7,8,1,3,8,2,7,8,7,6,7,8,5,7,null,7,2,2,0,9,6,0,1,8,4,1,0,4,5,5,0,0,8,9,2,8,0,1,6,6,0,4,null,7,1,null,1,0,6,0,null,2,6,null,null,1,null,7,1,6,4,null,5,2,9,5,8,2,6,0,5,9,5,7,9,null,4,null,1,null,1,6,null,null,1,0,null,null,7,7,6,3,4,9,4,9,4,9,5,5,null,3,6,4,6,8,7,0,1,9,9,null,0,7,1,5,null,2,6,8,1,0,2,8,6,null,8,8,3,null,2,0,6,null,7,8,7,8,null,8,null,5,0,7,7,0,0,3,null,null,8,null,9,4,4,1,5,2,0,2,8,1,0,7,0,8,2,5,null,2,6,null,0,null,null,5,4,7,null,0,null,1,1,7,5,9,1,1,9,5,null,8,8,6,1,8,9,null,9,6,2,3,null,8,3,8,5,6,1,1,null,7,9,3,3,3,5,2,7,7,9,5,null,5,9,null,6,null,9,0,7,8,6,4,8,0,null,null,1,3,6,8,null,9,null,null,8,null,null,5,null,3,4,null,9,9,9,null,3,1,1,3,1,8,3,4,6,8,7,5,9,2,null,3,5,null,3,null,5,4,1,8,8,4,0,3,2,0,1,4,9,null,6,5,null,1,0,6,3,8,7,null,2,1,5,2,8,3,5,5,1,null,3,7,4,6,6,6,4,8,9,4,null,8,null,7,null,6,4,8,6,null,6,9,0,3,3,null,4,7,7,7,1,4,3,null,5,9,8,null,null,1,6,3,2,3,6,2,5,1,8,9,3,1,1,9,4,4,null,8,7,7,2,1,9,3,0,1,3,0,3,9,3,1,2,8,null,6,7,9,2,8,9,0,3,2,null,6,4,3,null,9,8,0,5,6,0,2,8,5,9,4,2,3,4,4,6,9,4,8,0,3,6,2,0,2,1,null,0,3,4,null,3,7,1,null,0,null,1,0,7,5,5,9,0,9,7,0,8,0,0,1,null,6,6,1,5,null,1,0,3,4,1,null,null,4,null,null,7,7,null,7,7,4,9,5,8,1,null,1,7,0,8,null,9,null,null,0,9,null,2,null,5,null,9,3,2,1,6,6,5,2,3,7,9,null,4,8,8,null,2,null,null,1,4,5,9,6,3,null,4,null,null,0,null,1,5,1,9,null,1,5,null,2,3,2,null,5,3,null,3,3,5,7,2,1,null,6,7,8,7,4,1,null,6,0,1,4,6,2,3,1,7,7,0,2,8,7,9,5,1,3,8,3,1,6,9,4,7,3,6,2,0,null,null,2,8,6,9,2,null,null,1,3,2,9,null,7,null,null,9,7,null,null,7,2,9,4,8,6,4,1,7,3,8,5,4,5,null,9,5,7,8,7,0,6,7,7,null,2,3,6,3,7,8,8,0,7,null,3,6,2,6,2,6,6,7,5,0,9,1,9,8,9,null,null,5,8,2,5,8,null,5,3,null,2,7,7,null,3,5,3,3,0,7,6,0,9,9,2,3,6,3,4,9,null,7,1,5,4,7,null,1,2,9,8,9,null,2,3,4,1,2,2,1,4,0,9,0,8,0,2,1,8,0,2,2,6,3,3,null,3,null,0,4,8,9,1,4,6,4,4,null,0,0,7,null,5,4,2,2,2,3,3,4,7,6,null,8,4,7,null,6,9,7,2,2,0,4,null,2,3,7,8,0,null,6,null,1,4,6,4,7,6,9,3,4,2,null,2,3,null,7,7,7,5,4,9,8,null,4,2,7,null,7,4,2,8,8,9,9,8,6,4,8,3,6,4,0,4,null,1,6,7,7,3,null,0,6,7,9,2,5,9,6,2,9,3,7,5,null,3,5,9,3,null,4,2,0,null,0,null,0,null,1,4,null,5,5,4,8,5,null,null,2,7,0,2,null,7,4,8,7,8,2,0,0,7,null,null,6,7,null,8,5,0,null,6,0,1,4,null,null,9,1,null,0,4,6,4,4,9,4,0,7,7,3,9,null,null,9,5,3,6,null,9,2,1,0,6,null,6,5,3,null,7,4,1,9,null,6,9,2,1,6,null,8,6,null,4,0,5,0,8,2,7,9,4,6,3,9,9,9,1,0,null,8,6,4,8,2,0,0,8,6,0,null,2,3,null,9,7,4,8,9,8,1,9,0,8,9,null,null,1,7,3,null,8,7,4,6,8,8,5,null,9,5,8,6,2,8,2,1,null,0,9,null,5,1,null,2,6,3,4,2,0,3,5,4,null,null,8,null,8,8,0,8,1,3,9,5,2,5,0,2,null,6,1,9,6,6,5,7,5,null,2,5,9,null,7,9,null,6,7,5,8,7,8,0,4,7,null,0,0,null,6,3,3,null,7,1,8,2,4,9,9,7,4,7,5,1,3,8,0,1,9,8,9,2,null,8,null,6,3,0,2,4,7,3,5,5,4,3,1,6,2,1,1,3,7,3,9,7,9,6,8,9,5,5,6,9,9,8,null,9,0,0,null,0,8,null,0,4,8,null,1,6,9,1,5,4,4,5,3,5,null,9,9,9,9,5,4,0,7,4,8,1,0,3,1,4,6,9,null,9,7,4,7,3,7,5,3,null,null,9,5,2,6,null,9,4,0,null,7,2,3,7,6,2,0,1,7,1,3,1,6,8,null,9,5,null,4,null,5,2,5,null,2,null,2,4,2,4,5,3,null,8,3,1,9,3,4,null,2,2,2,4,null,3,7,1,null,1,4,6,1,8,null,8,4,2,5,3,7,2,3,8,4,5,8,null,3,1,null,0,4,4,0,6,3,1,0,2,9,9,3,null,8,0,6,4,1,2,1,5,1,6,7,9,null,4,6,1,8,6,3,9,null,3,2,2,6,0,6,2,0,0,6,5,1,9,7,2,3,null,4,1,1,7,8,2,1,null,9,4,null,null,7,7,5,2,9,9,5,0,8,1,6,7,0,2,1,null,0,9,4,6,null,null,8,5,6,6,4,2,null,8,2,null,7,4,null,null,null,null,3,6,null,0,null,5,null,1,8,1,0,5,6,5,6,0,0,7,2,null,7,null,8,9,0,8,8,9,null,2,8,2,9,3,null,null,3,1,4,0,6,3,null,4,null,8,7,7,null,7,0,5,1,0,7,9,8,2,7,8,1,0,6,5,0,5,null,3,5,2,null,null,6,null,1,3,null,5,2,8,5,9,2,5,3,6,null,6,0,null,5,1,0,8,2,0,7,0,8,2,6,null,4,0,5,null,7,4,4,5,6,1,5,4,4,9,0,0,9,2,4,1,2,9,6,0,0,9,1,7,2,4,9,4,0,7,4,3,2,5,1,0,8,null,1,2,null,1,8,9,8,8,2,9,5,0,3,0,4,6,8,null,5,2,5,7,9,2,4,4,0,1,8,null,5,9,8,0,null,2,7,8,9,7,null,7,8,null,null,4,null,9,2,1,1,0,1,6,5,8,3,5,8,7,9,2,5,1,4,6,null,6,0,4,9,8,0,8,4,6,1,8,4,3,null,4,5,6,null,2,null,9,8,7,7,1,9,8,8,6,0,1,6,6,3,1,6,1,0,2,null,1,5,0,8,null,7,null,4,5,7,null,8,null,1,9,7,2,2,null,0,7,6,1,null,1,null,4,1,0,5,1,3,5,5,1,2,9,5,null,9,6,5,1,1,8,2,2,4,null,6,8,null,6,4,0,null,5,0,3,3,1,7,1,3,3,8,7,null,9,0,null,9,3,9,null,null,7,null,3,0,3,null,7,null,1,6,null,6,null,1,3,9,7,1,1,4,5,9,8,9,6,1,0,null,8,3,4,2,5,6,4,null,2,null,2,2,9,2,4,1,7,9,2,2,0,0,5,null,0,7,9,null,2,null,null,0,null,6,9,null,8,5,4,null,null,8,5,2,null,null,2,0,null,1,8,7,null,9,6,3,0,9,7,8,5,1,4,8,7,8,0,null,0,7,5,8,2,null,8,2,4,4,null,5,0,1,8,7,3,9,6,2,5,5,1,3,3,8,3,1,2,4,null,0,8,3,7,2,null,null,1,7,0,0,6,4,2,0,6,6,4,7,7,6,2,1,1,6,2,7,8,null,9,null,9,0,9,7,5,4,2,6,null,1,0,4,8,6,5,0,9,8,9,3,3,null,8,2,3,5,null,1,6,6,3,8,5,null,1,3,5,5,6,2,0,3,null,6,4,7,null,3,2,3,9,5,0,7,9,3,7,3,8,4,2,null,9,4,6,null,7,6,8,3,6,0,6,null,9,5,null,null,1,1,5,2,8,4,1,0,1,4,5,7,4,6,4,null,0,7,null,9,null,4,0,9,5,4,2,1,2,null,5,4,null,null,8,6,8,6,null,3,6,9,8,3,2,0,3,2,5,9,null,null,1,null,6,0,0,5,9,2,4,null,2,3,3,5,4,6,null,4,8,null,2,5,0,null,null,1,null,5,2,null,8,9,2,7,1,4,3,6,6,9,7,7,null,9,null,7,null,5,9,0,5,7,4,8,4,2,4,6,8,1,null,8,5,null,3,7,7,9,5,3,null,null,1,0,1,8,6,3,2,1,8,null,0,3,6,3,1,7,9,9,1,2,5,0,7,1,7,6,9,8,7,2,4,0,3,7,5,4,9,6,null,0,8,2,3,5,null,4,1,7,5,7,7,8,7,9,null,7,3,null,1,2,6,5,8,9,2,3,8,0,0,9,null,4,0,3,3,null,4,6,0,null,4,5,7,5,8,2,0,null,7,1,null,2,5,3,8,9,8,5,0,null,8,null,null,9,5,7,null,7,null,3,2,8,0,null,9,1,1,5,2,7,0,null,0,5,0,5,null,4,8,7,0,2,8,4,0,8,5,4,9,0,null,4,8,4,3,4,2,9,5,null,3,null,2,3,null,3,null,8,3,5,1,1,3,5,8,9,null,1,1,4,9,null,3,7,1,null,5,4,8,1,4,9,0,3,2,null,6,null,3,null,4,3,4,2,4,5,5,4,6,1,4,0,4,1,0,3,5,1,5,3,9,8,7,3,1,2,null,0,7,4,9,7,8,7,null,1,0,9,8,6,0,7,0,3,3,7,0,9,1,5,9,5,2,4,0,6,0,4,4,5,null,0,9,7,1,7,8,8,6,3,9,null,0,5,5,5,7,6,9,null,8,6,9,null,9,4,5,0,null,2,2,null,4,9,2,1,null,6,5,8,2,8,6,8,5,8,2,null,0,null,7,7,8,3,0,4,null,3,7,null,0,9,1,5,6,9,6,3,6,1,5,0,null,4,7,0,0,9,0,3,7,1,9,0,null,9,1,6,null,3,0,1,null,0,null,4,0,8,3,3,8,3,1,8,9,7,6,9,0,4,6,1,9,6,6,1,3,2,4,5,null,null,5,null,5,8,null,3,7,6,5,6,0,0,3,7,9,3,9,null,0,2,3,8,4,null,0,3,6,6,8,null,1,6,0,9,4,2,7,9,0,1,null,0,5,8,6,5,null,5,7,3,0,2,7,0,9,null,5,1,4,1,2,null,6,2,4,3,1,1,4,5,4,null,5,6,4,0,0,5,6,8,9,0,9,9,7,3,8,4,5,4,null,null,8,0,null,5,3,8,8,null,null,1,4,null,null,4,5,6,0,0,1,0,null,8,5,null,0,6,6,null,6,6,4,2,6,null,2,0,1,2,1,6,3,4,5,3,null,1,0,3,8,0,4,5,8,null,null,5,2,9,9,9,7,4,1,5,null,0,5,5,0,0,1,null,9,null,2,null,null,0,2,null,2,4,1,9,3,1,5,3,3,5,3,8,9,3,9,7,9,null,null,6,2,1,1,null,5,6,5,4,7,4,null,1,4,null,2,9,null,9,0,6,8,7,null,6,null,8,5,null,0,0,0,1,4,null,8,null,null,9,null,8,7,1,6,5,6,null,6,7,1,null,7,4,null,null,5,2,null,0,9,8,null,6,2,4,null,null,null,5,0,null,9,1,9,8,9,8,4,null,8,1,5,null,null,7,0,4,6,2,6,6,7,null,0,7,5,0,2,9,7,8,null,1,6,7,9,5,0,4,6,9,6,4,3,2,6,2,8,6,7,2,9,7,2,9,9,8,5,5,0,2,5,9,4,0,1,7,2,5,null,6,4,4,7,6,4,1,0,8,7,5,7,3,1,1,4,1,null,4,1,8,4,null,0,5,2,3,3,9,7,9,8,null,null,3,null,9,6,2,7,0,1,null,8,null,null,3,1,0,4,0,8,9,9,8,2,0,null,8,7,5,null,null,6,3,null,0,4,0,4,1,8,1,9,9,0,8,8,6,null,8,1,6,4,5,0,2,0,1,4,7,5,3,6,7,null,3,6,4,7,4,6,6,7,8,6,1,3,null,null,9,2,3,4,9,3,null,8,2,6,7,2,9,7,null,null,8,2,6,9,8,9,1,9,7,0,null,2,1,null,2,3,null,0,7,8,1,6,7,1,7,4,null,7,null,1,1,9,3,9,5,1,2,3,2,7,null,null,1,3,0,8,6,6,2,2,9,1,4,8,6,9,null,1,9,2,3,2,0,3,8,null,6,0,4,0,4,null,null,1,4,9,8,7,null,3,2,2,9,8,2,5,2,9,5,7,null,9,8,null,9,3,8,0,null,3,9,6,8,8,8,3,null,null,4,6,6,2,9,3,5,6,4,7,3,7,0,3,3,8,null,null,null,4,6,3,3,4,0,6,2,3,0,null,7,6,1,8,1,null,null,0,null,null,9,7,8,1,3,null,1,4,2,8,7,8,8,6,null,null,3,1,2,8,1,4,8,8,9,null,0,7,null,1,0,6,5,7,null,8,7,8,4,7,4,6,3,3,8,3,2,0,6,2,8,null,9,0,7,4,null,5,9,5,8,5,9,8,3,8,null,null,9,4,2,9,6,2,1,2,null,null,5,1,0,2,6,7,6,3,null,5,6,8,3,6,9,9,7,null,7,0,1,9,4,7,0,1,3,0,4,9,8,0,2,4,9,2,2,3,8,2,0,4,3,null,7,9,1,3,4,8,null,2,null,5,6,3,5,5,5,5,7,null,null,3,1,7,4,1,null,5,5,1,8,7,8,3,0,0,1,5,1,5,5,2,0,1,1,3,null,7,4,4,8,9,null,8,null,7,9,5,1,null,0,9,2,4,null,0,1,5,9,0,0,6,1,0,0,2,null,null,5,9,null,6,8,1,6,1,2,9,null,2,2,9,4,9,5,8,6,4,7,9,4,9,3,null,2,null,4,4,8,4,4,0,8,2,3,0,5,2,2,7,4,7,1,null,8,0,6,6,8,2,6,null,8,4,3,1,7,null,7,2,2,2,8,9,2,1,null,2,9,8,0,6,null,null,2,8,5,7,2,1,8,5,4,1,4,1,9,0,3,1,0,8,3,2,4,8,3,6,4,0,5,3,8,2,5,8,8,3,9,null,9,null,2,9,1,null,7,null,7,1,8,8,4,5,7,5,2,null,3,null,4,7,0,5,0,3,0,4,8,3,null,0,6,9,7,9,null,4,9,4,null,0,5,2,4,null,9,3,0,5,3,2,3,8,3,7,9,1,0,2,4,6,2,0,2,8,3,5,2,3,4,8,4,0,6,null,null,5,null,4,null,3,null,2,2,9,9,null,6,0,null,8,0,9,null,4,2,9,4,2,2,0,3,0,1,8,8,3,null,4,7,8,4,null,9,8,null,8,9,4,4,3,2,5,2,null,5,4,6,0,4,null,2,7,null,1,5,9,2,6,null,4,8,null,3,4,7,8,9,null,null,1,null,4,null,6,4,null,7,7,0,7,4,8,7,4,2,0,8,2,0,0,8,6,7,7,7,7,5,3,null,6,6,5,null,null,4,9,4,null,3,9,null,2,7,5,null,null,1,9,8,0,4,4,5,8,1,4,7,9,2,1,9,9,8,8,5,null,5,1,3,9,null,2,4,0,3,2,0,3,3,null,6,6,null,8,null,2,5,5,7,5,1,null,4,5,0,7,1,9,null,3,null,2,4,8,1,6,0,9,3,4,9,null,4,4,6,2,0,null,7,7,0,9,7,null,null,6,5,8,null,3,8,1,0,2,9,0,3,9,3,6,1,3,0,null,5,2,9,4,null,5,8,6,null,null,1,8,6,null,0,5,0,5,null,1,null,7,8,3,null,1,7,1,4,3,3,9,0,2,3,9,9,6,null,2,4,2,2,6,8,7,null,8,null,9,9,5,7,3,9,null,null,1,2,4,1,0,9,7,7,9,7,5,4,2,8,1,null,4,2,5,8,2,2,9,3,1,2,3,1,0,8,5,6,null,2,0,2,9,7,8,4,null,6,8,1,6,null,6,7,0,0,9,8,8,8,1,null,5,5,2,9,4,3,3,1,0,5,1,7,3,3,5,7,1,8,4,2,5,7,2,4,null,4,0,7,0,9,6,5,null,0,null,3,1,4,9,null,null,4,1,6,2,2,1,5,3,8,7,5,6,6,9,4,6,9,3,1,6,7,null,null,null,null,6,null,9,3,2,6,3,null,8,3,0,null,9,6,8,2,2,null,4,4,null,3,3,2,null,3,6,null,5,5,4,3,7,1,8,null,null,2,8,null,5,4,3,9,null,6,null,6,4,4,6,9,7,3,3,1,2,8,7,2,6,8,7,8,7,null,4,9,3,null,7,5,5,8,4,7,2,7,2,8,3,8,1,2,null,5,null,1,9,2,9,0,9,9,9,null,7,3,8,7,8,1,2,7,4,6,4,3,4,7,9,5,8,0,3,null,8,3,3,5,9,null,7,1,4,2,6,0,6,6,3,8,5,0,null,2,6,null,7,null,0,null,null,6,7,null,6,4,7,5,5,7,9,4,0,null,1,4,0,null,5,4,8,7,null,2,1,9,0,9,6,5,9,7,8,0,6,0,null,0,7,9,9,null,null,7,5,5,9,4,1,8,3,1,3,3,0,1,4,0,null,null,1,9,9,1,3,7,null,6,1,8,6,null,1,2,9,4,3,null,6,3,4,6,null,9,7,6,7,8,1,6,3,6,8,3,null,6,1,7,2,7,1,2,5,2,1,5,2,null,5,9,1,2,3,8,6,5,3,7,5,0,null,3,1,null,2,null,2,null,7,7,5,6,null,1,5,4,2,null,null,null,1,9,6,0,null,7,3,1,7,8,1,8,0,8,3,null,1,3,8,2,2,4,4,9,null,5,9,0,6,4,null,3,0,7,6,2,null,0,1,4,7,7,3,6,null,1,4,null,7,9,4,null,6,1,2,1,8,8,8,1,0,7,2,null,9,5,1,7,0,9,2,0,null,1,null,1,null,3,8,8,5,null,null,null,0,6,1,1,9,8,2,1,null,6,8,0,0,null,7,0,9,5,2,7,5,null,2,null,8,8,7,7,9,null,9,8,5,6,9,9,7,9,null,null,1,null,6,6,null,2,3,6,7,2,null,1,1,7,4,null,6,1,2,null,6,8,6,null,3,3,3,0,null,7,4,5,7,8,3,6,5,9,5,9,7,0,3,5,5,2,6,null,9,8,2,5,9,5,3,5,9,0,4,2,5,8,2,9,null,null,5,3,0,7,4,7,7,null,6,4,9,0,0,0,6,4,1,null,5,8,4,4,8,null,7,null,4,3,1,1,9,null,1,1,1,7,null,4,null,0,null,4,6,9,7,5,7,null,null,5,6,6,6,3,null,6,2,8,9,6,2,8,0,9,null,5,3,8,8,null,5,9,5,1,3,4,null,null,3,5,null,9,2,0,9,3,null,3,null,1,8,5,8,7,6,5,null,6,1,5,3,null,7,5,null,8,3,0,3,9,9,null,null,9,4,null,9,0,null,7,0,8,5,7,5,null,5,null,5,8,null,0,null,null,2,2,8,5,6,3,2,8,9,7,0,2,2,null,1,6,8,8,0,null,1,6,8,5,2,0,8,7,5,null,7,1,8,9,4,8,3,8,3,4,null,4,2,1,8,5,3,0,9,1,null,null,2,6,3,8,null,1,0,1,8,0,2,3,1,null,null,null,8,0,2,6,0,null,4,6,9,7,9,2,null,null,null,9,2,7,5,8,null,6,3,9,9,5,6,5,0,6,1,6,6,7,7,9,7,9,7,2,0,5,1,7,8,1,9,5,5,9,7,1,4,3,6,0,9,4,1,6,5,2,8,8,2,6,6,1,null,7,0,5,7,1,9,3,4,9,9,6,3,5,null,7,6,0,3,1,1,8,8,8,6,6,1,8,9,1,3,1,8,5,3,7,1,3,8,8,7,6,3,null,null,2,4,null,4,0,2,9,0,7,8,5,8,7,6,3,6,4,null,5,4,0,null,5,8,8,3,9,null,9,2,1,3,9,2,5,9,3,8,null,1,6,9,null,1,4,2,6,1,7,null,7,1,null,2,7,4,7,6,0,6,null,2,8,6,null,null,2,2,5,3,8,null,7,7,2,1,6,null,7,5,null,0,6,7,8,null,7,7,8,null,2,7,9,null,9,1,2,8,3,0,4,8,null,4,3,9,1,null,9,5,8,5,null,0,9,9,0,5,7,3,null,2,8,3,null,7,1,null,7,9,8,8,9,2,6,8,3,0,6,6,2,3,5,5,1,3,0,0,2,2,4,5,4,null,0,null,0,2,null,9,null,4,7,3,9,7,8,null,8,9,1,2,8,6,5,2,7,6,0,null,null,7,null,5,null,8,2,9,5,3,5,7,4,6,3,4,null,3,9,5,null,null,4,6,0,4,2,3,7,2,4,2,3,8,6,9,2,0,3,0,3,null,1,9,0,null,7,2,6,7,1,null,3,3,8,9,6,null,3,2,null,3,1,0,null,null,2,null,1,0,null,1,0,null,0,5,7,1,9,9,2,5,9,7,null,2,8,3,0,0,8,9,1,9,1,4,8,null,5,2,4,6,9,0,7,null,2,1,7,null,null,4,9,0,0,null,2,6,5,4,8,null,9,null,8,1,1,0,0,2,7,3,null,7,null,2,4,6,8,0,4,8,2,6,4,8,null,3,7,4,6,7,null,3,2,null,8,5,5,4,null,8,4,5,7,2,1,4,8,0,3,5,0,7,0,null,8,null,0,5,2,null,8,5,4,null,3,6,9,null,8,8,4,0,1,1,6,2,2,5,null,3,8,null,2,null,0,null,5,6,9,5,9,null,8,9,7,5,2,8,2,3,6,6,null,6,0,3,7,9,2,6,4,0,2,0,4,null,9,7,6,4,null,7,8,null,3,2,8,9,1,null,4,3,8,8,4,0,7,null,1,5,7,4,6,null,6,3,1,1,6,null,8,1,7,8,2,4,5,6,6,6,null,3,null,3,8,1,9,null,0,5,0,5,3,8,5,0,7,9,5,0,3,7,1,6,6,4,3,5,5,9,null,1,0,9,6,3,9,3,null,2,8,2,7,5,3,7,null,7,2,0,1,7,6,9,8,0,null,6,null,3,null,3,0,1,4,7,3,0,null,0,0,8,0,0,9,3,0,4,5,0,6,0,0,0,4,4,6,1,8,4,8,7,5,8,5,6,2,null,4,0,0,7,7,null,3,9,8,3,9,3,5,1,9,7,8,8,5,7,4,null,4,5,6,0,6,1,9,1,6,0,5,2,4,2,null,2,5,3,3,4,7,3,7,7,0,0,8,6,3,6,null,null,9,2,7,2,4,7,8,1,null,2,8,4,4,9,1,9,8,null,7,2,4,0,0,1,1,null,4,8,9,null,5,2,null,5,2,9,1,7,8,5,7,3,1,null,5,7,2,0,3,2,7,6,8,5,null,4,2,4,null,0,9,null,3,5,3,7,4,null,9,null,1,9,null,8,3,7,5,1,3,2,6,3,null,8,6,9,8,null,7,1,8,7,7,4,5,4,9,null,4,5,3,0,4,9,null,5,5,5,0,9,null,5,6,8,6,2,2,null,9,0,6,2,4,2,0,7,6,1,9,null,null,8,6,2,8,7,3,null,4,4,7,9,7,6,6,null,7,3,5,8,null,null,7,7,null,8,null,9,0,8,6,0,1,3,8,2,6,4,5,7,6,5,3,4,8,8,7,2,null,6,1,4,0,2,6,1,9,7,2,4,0,8,7,4,7,3,4,6,3,9,4,4,1,4,6,6,5,7,7,null,3,7,null,4,5,1,1,9,6,8,1,6,1,2,6,7,9,3,null,0,8,6,null,null,6,4,2,2,3,9,6,1,3,null,2,0,null,2,6,null,5,9,9,null,1,7,0,4,7,null,2,null,0,5,7,8,0,9,7,null,8,7,8,3,1,4,3,null,4,7,1,8,4,8,2,3,2,3,2,3,3,8,9,7,3,5,7,7,3,null,3,4,5,2,0,4,null,5,4,8,4,8,0,9,null,1,9,3,3,null,3,null,null,9,null,6,1,7,3,4,null,0,2,6,7,3,8,null,1,null,5,8,9,null,5,0,4,5,4,1,8,1,2,6,2,0,4,9,6,0,2,5,8,0,null,6,null,3,5,1,6,3,9,7,8,8,4,4,null,0,0,0,7,5,null,null,6,3,5,4,5,6,4,7,null,4,1,7,3,9,null,null,5,0,null,9,4,null,4,5,6,6,6,2,null,7,6,3,1,3,null,0,5,9,6,null,7,3,2,3,1,6,6,null,3,4,1,7,4,7,2,2,0,6,1,2,2,3,4,6,8,null,2,2,3,null,null,6,3,7,3,9,null,8,3,4,1,0,0,5,4,9,8,5,5,8,9,0,2,2,3,7,0,3,7,8,0,8,4,2,null,8,6,null,null,0,3,5,6,9,9,1,9,null,1,1,null,9,null,0,3,2,null,7,7,8,7,4,7,9,6,7,0,8,8,1,null,4,2,9,3,null,null,2,5,7,6,3,7,null,3,6,0,2,0,7,7,5,0,0,null,1,9,5,2,8,2,5,4,0,1,3,4,0,null,null,2,4,2,2,null,5,9,2,3,9,8,null,9,null,4,null,4,2,4,3,1,6,6,1,0,null,6,1,2,null,2,5,2,3,5,2,null,null,3,null,4,8,3,null,8,6,1,0,0,5,3,3,null,null,6,3,9,6,8,1,3,6,5,null,3,4,5,8,1,5,9,7,7,4,3,null,2,null,null,4,3,0,9,1,4,3,2,1,2,2,5,5,1,5,8,3,7,3,null,7,2,null,7,0,9,7,5,1,9,5,4,7,null,5,5,3,3,null,2,6,null,5,0,9,7,4,6,0,4,3,3,null,5,8,1,9,9,4,6,9,5,9,null,9,4,8,9,null,null,2,8,6,0,null,3,null,0,2,5,null,2,5,8,5,null,null,0,0,8,null,9,9,0,0,9,null,5,4,0,2,3,1,9,2,2,5,1,6,3,1,5,null,8,9,4,0,5,null,3,4,1,2,0,null,5,4,8,1,5,null,null,7,9,3,6,6,0,9,5,2,6,2,null,2,1,7,null,1,6,4,0,0,0,4,0,8,4,9,8,9,null,2,6,6,7,4,1,3,4,null,9,6,9,7,null,0,2,5,0,1,3,4,1,1,8,3,1,9,6,6,null,8,6,0,5,5,2,8,9,null,0,8,3,5,8,7,null,7,null,null,7,5,2,5,null,0,3,null,2,2,1,null,3,2,2,9,3,6,null,0,6,0,null,null,2,0,9,3,null,3,4,null,7,7,8,null,6,0,6,6,null,8,0,null,0,3,1,3,7,0,5,0,0,6,null,2,3,8,0,0,7,2,2,7,7,5,0,1,null,3,4,3,4,1,3,4,2,null,8,null,7,4,3,6,9,4,1,0,0,5,2,null,8,8,9,8,3,null,7,0,2,2,5,1,4,9,null,6,2,5,6,0,2,7,9,9,1,null,5,3,null,7,7,6,4,1,3,7,1,6,0,7,9,3,8,3,null,7,2,5,6,1,0,4,5,6,null,9,0,3,0,null,null,null,1,null,5,0,6,1,5,6,1,3,0,4,1,2,5,6,null,1,2,6,4,null,null,3,4,5,7,3,null,4,3,null,2,0,4,7,6,2,0,3,null,8,8,2,9,4,7,5,8,0,3,null,null,6,1,6,null,3,2,1,null,3,3,9,3,9,null,7,9,6,8,7,1,6,null,3,8,3,0,2,4,5,2,0,5,9,5,9,0,7,2,7,5,5,5,7,4,8,6,1,6,null,null,7,null,2,2,6,4,null,null,4,7,null,7,3,2,3,9,0,4,2,0,9,5,2,2,9,0,null,2,2,3,null,8,7,null,7,8,6,1,7,2,null,9,3,1,1,2,null,6,7,5,5,8,null,0,4,2,0,5,5,0,6,5,9,1,null,9,4,1,8,null,7,6,6,7,5,1,8,7,9,0,6,1,4,null,7,1,5,4,1,4,4,3,null,9,8,9,null,1,5,3,3,7,null,5,4,3,7,8,2,4,8,null,4,null,null,8,null,1,null,0,3,1,3,4,4,7,9,0,1,5,null,9,null,6,8,7,null,4,null,1,null,8,6,0,7,4,3,5,9,1,0,8,2,9,7,null,1,5,8,5,8,9,5,8,null,null,4,5,4,0,9,9,0,8,5,2,9,2,0,null,4,7,7,8,1,9,6,null,3,4,4,1,7,9,8,0,8,null,5,3,3,6,5,7,null,null,0,6,9,1,2,8,6,9,0,5,2,3,8,9,8,0,3,3,0,1,4,null,9,0,1,3,6,2,6,0,null,0,9,3,9,3,3,3,5,1,null,null,1,1,7,null,null,8,3,null,null,9,5,6,6,7,7,0,2,null,6,7,9,4,8,9,2,null,4,8,6,4,null,5,8,8,3,9,8,7,9,null,2,9,2,9,1,1,3,0,6,7,3,4,2,9,null,6,null,4,null,2,8,2,3,4,1,3,0,null,4,7,8,4,8,null,6,3,3,7,0,null,3,9,3,1,1,2,0,2,6,4,8,9,0,8,7,1,1,6,4,0,3,0,2,7,0,null,1,null,null,null,9,0,null,null,7,8,2,null,5,5,8,null,3,5,2,2,2,5,3,7,7,5,8,8,1,4,null,null,7,9,7,2,4,7,7,6,8,null,1,6,3,2,9,7,1,2,7,0,2,9,9,9,9,8,null,7,null,4,8,7,0,null,9,3,3,null,7,1,null,null,9,5,8,8,4,7,4,9,5,5,1,null,0,6,6,8,7,8,null,null,null,3,4,6,5,1,0,null,null,1,5,1,3,null,3,4,6,4,8,2,2,2,null,2,5,1,6,null,6,5,null,1,4,2,2,2,7,8,2,7,4,0,2,3,3,null,7,0,null,7,9,6,0,null,2,8,4,8,5,2,3,6,8,2,2,6,1,8,5,4,6,2,4,0,0,4,9,7,7,null,1,1,null,6,6,6,4,1,null,3,4,null,5,0,8,8,1,8,3,2,9,6,2,6,9,5,9,8,5,1,0,7,7,null,8,9,0,8,8,null,6,3,6,6,9,8,1,4,1,5,5,0,7,7,0,9,9,1,5,3,5,6,null,null,null,4,null,0,4,null,2,6,5,1,4,6,1,5,4,6,7,4,2,6,7,0,4,3,null,8,4,8,7,9,4,0,5,6,3,7,1,9,3,null,7,3,4,9,0,0,3,2,0,6,6,0,6,5,0,8,3,1,2,4,8,3,6,null,3,1,7,3,7,0,7,2,2,5,2,8,8,5,8,9,3,7,9,9,8,6,6,5,8,null,8,null,5,7,1,0,4,9,5,2,8,null,1,0,4,7,2,3,2,2,5,0,4,5,0,3,null,7,0,7,2,3,null,null,1,5,0,5,5,8,4,4,2,7,2,1,0,5,8,2,5,4,null,3,5,2,7,0,0,0,8,2,5,6,0,4,0,3,8,4,null,1,2,8,null,4,2,8,3,2,1,2,4,6,null,4,4,null,1,4,5,0,9,2,3,null,null,3,2,3,3,0,8,3,3,3,3,1,6,2,3,4,4,2,3,null,6,7,3,9,9,5,1,0,2,3,4,8,5,1,5,3,0,null,4,3,7,null,0,1,7,null,4,5,null,9,5,9,null,3,5,5,7,7,8,0,0,8,7,9,9,9,4,9,5,3,null,5,7,4,null,1,null,7,null,1,null,3,6,9,null,4,4,1,null,2,0,6,9,2,9,1,8,3,9,0,2,6,8,1,null,6,4,4,2,5,0,1,0,9,4,6,4,8,8,null,1,null,3,5,0,0,4,0,5,5,4,5,4,0,8,9,4,2,3,1,null,null,null,3,4,1,0,2,2,1,null,null,0,6,0,2,5,2,null,2,3,4,0,null,1,0,9,2,2,6,8,null,8,null,6,9,2,null,2,9,5,3,null,8,2,9,7,6,null,2,3,9,null,6,9,7,3,7,null,6,5,9,8,5,5,4,7,5,2,null,4,3,8,8,8,7,9,4,5,6,1,0,null,9,1,5,2,0,null,9,2,3,5,1,5,1,1,7,3,0,0,9,7,9,0,8,6,9,2,7,0,null,2,8,8,9,3,4,8,9,2,9,7,null,null,2,2,null,4,7,3,8,3,3,5,null,5,3,9,2,7,3,3,7,null,null,3,9,1,3,null,8,1,4,0,7,6,null,4,8,8,4,7,null,3,6,9,4,9,7,9,8,null,null,2,1,8,3,8,2,0,0,9,5,2,null,9,5,7,1,null,3,8,null,5,6,5,2,1,4,2,9,9,2,8,5,7,6,0,4,0,3,6,2]\"");
        TreeNode treeNode = sbt.deserialize("[5,2,3,null,null,2,4,3,1]");
        System.out.println(System.currentTimeMillis() - time1);
    }

    public String serialize(TreeNode root) {
        if (null == root)
            return "[null]";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        String result = "[";
        boolean flag = true;
        while (flag) {
            flag = false;
            int i = queue.size();
            String temp = "";
            while (i > 0) {
                TreeNode outNode = queue.remove();
                if (outNode == null) {
                    temp += "null,";
                    queue.add(null);
                    queue.add(null);
                } else {
                    flag = true;
                    temp += (outNode.val + ",");
                    queue.add(outNode.left);
                    queue.add(outNode.right);
                }
                i--;
            }
            if (flag)
                result += temp;
        }
        result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }

    public TreeNode deserialize(String data) {
        data = data.replaceAll("\\]","");
        data = data.replaceAll("\\[","");
        String[] datalist = data.split(",");
        List<TreeNode> treeNodes = new ArrayList<>(datalist.length+1);
        treeNodes.add(0,new TreeNode(0));
        for(int i = 0 ; i < datalist.length;i++)
        {
            if(!datalist[i].equals("null"))
            {
                TreeNode treeNode = new TreeNode(Integer.valueOf(datalist[i]));
                treeNodes.add(i+1,treeNode);
                if(i!=0&&treeNodes.get((i+1)>>1)!=null)
                {
                    if((i+1)%2==0)
                    {
                        treeNodes.get((i+1)>>1).left = treeNode;
                    }else {
                        treeNodes.get((i+1)>>1).right = treeNode;
                    }
                }
            }else {
                treeNodes.add(i+1,null);
            }
        }

        return treeNodes.get(1);
    }
    // Decodes your encoded data to tree.
    /*public TreeNode deserialize(String data) {
        if (data.equals("[]"))
            return null;
        data = data.replaceAll("\\]", "");
        data = data.replaceAll("\\[", "");
        String[] datalist = data.split(",");
        if (datalist[0].equals("null"))
            return null;
        TreeNode headTreeNode = new TreeNode(Integer.valueOf(datalist[0]));
        recur(headTreeNode, 1, datalist);
        return headTreeNode;
    }*/

    public void recur(TreeNode rootnode, int startIndex, String[] datalist) {
        startIndex = startIndex << 1;
        if (rootnode == null || startIndex - 1 >= datalist.length)
            return;

        rootnode.left = datalist[startIndex - 1].equals("null") ? null : new TreeNode(Integer.valueOf(datalist[startIndex - 1]));
        if (startIndex < datalist.length)
            rootnode.right = datalist[startIndex].equals("null") ? null : new TreeNode(Integer.valueOf(datalist[startIndex]));
        recur(rootnode.left, startIndex, datalist);
        recur(rootnode.right, startIndex + 1, datalist);

    }

}
