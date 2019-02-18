package com.sohu.yifanshi.test.inOrderTravelSal;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Solution {//二叉树的中序遍历
    //递归的进行二叉树的遍历是很简单的，但是迭代却很有难度。我们借助栈的帮助，用迭代的思想去想栈的遍历，就是从根节点到子节点，先由浅到深深入到底，把底层
    //的节点都遍历完了再一层层的从深到浅，把上层遍历完。这样的形式就很容易让我们想到栈，栈的入栈与出栈不正与这种形式相符合嘛？所以类似的问题，以后都要
    //记得用栈去解决。而且大多数我们难以解决的算法问题，我们都可以借助特定的数据结构去解决。数据结构本身出现也是为了解决算法问题的。
    //在这里以先序遍历为例，（左子叶，根节点，右子叶）。用一个指针来进行遍历，若指针不为空，则将此节点入栈，并且指针指向此节点的左子节点，继续循环。
    //若指针为空，就说明栈顶的节点，没有左子叶，也就说明这个栈顶节点的左子树遍历完毕。接下来我们要遍历他自己以及他的右子树。我们将他自己的值加入数组，
    //即为遍历自己，接下来指针指向他的右子节点，再次进入循环，就相当于用这个方法去遍历他的右子树了。遍历完右子树我们就需要遍历作为他兄弟的右子树，
    //但是此时有一个问题出现了。
    // 我们已经遍历完这个栈顶元素的右子树了，也就是说这个栈顶元素代表的整棵树已经遍历完了。按照顺序，我们就该遍历这个栈顶元素的父亲以及这个栈顶
    //元素的右兄弟节点。
    // 我们要访问这个栈顶元素的兄弟节点，就必须通过其父节点访问。他的父节点再栈中，还被他压着呢。如果我们等遍历完这个栈顶
    //元素的右子树再将其出栈，程序就需要进行是否遍历完毕的判断，这再我们的迭代循环中是十分难以做到的。不如我们再这个栈顶元素遍历自己时，就将其出栈，
    //因为我们只要将指针指向这个栈顶元素的右子树，如果程序正确的话，他一定回将右子树遍历完，所以这个栈存在的意义就是我们需要通过其拿到尚未遍历的那
    //一颗子树，只要我们拿到了这颗子树，栈中的这个元素就已经失去意义了。即可出栈。当我们遍历完这个栈顶元素(已出栈)的右子树，我们将pointer置为null，
    //当pointer为null时，程序将遍历这个已出站的栈顶元素的父节点，也就是现在的栈顶元素，以及现在栈顶元素的右子树，也就是这个已出栈的栈顶元素的右兄弟
    //子树。
    //再说一遍，这个栈的意义就是再遍历完其中一颗子树以后，用来获得另一颗子树的。当遍历完其中一颗子树，就应当把另一个子树赋值给指针并出栈，以便于上层
    //节点重复这个操作。如果出栈时机错误的话，就回导致再一颗子树中无限循环。或者一颗子树访问多次。

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

        List<Integer> list = floorOrderTravelSal(treeNode4);
        for(Integer num : list)
        {
            System.out.println(num);
        }
    }

   /* public static void inOrderTravelSal(TreeNode rootNode)
    {//递归中序遍历 左子树，根节点，右子树

        if(rootNode==null)
        return;
        inOrderTravelSal(rootNode.left);
        System.out.println(rootNode.val);
        inOrderTravelSal(rootNode.right);
    }*/

    public static List<Integer> inOrderTravelSal(TreeNode root)
    {
        List<Integer> resultList = new ArrayList<Integer>();
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode pointer = root;
        while (pointer!=null||!treeNodeStack.empty())
        {
            if(pointer!=null)//如果指针指向的节点不为空，就入栈，并且指针指向左孩子。
                //如果指针指向的节点为空，那么就将栈中的元素出栈，并访问此出栈元素的右孩子。如果右孩子也为空，那么就访问栈顶元素的右孩子（此种情况说
                // 明以此时栈顶元素为根节点的左子树已经遍历完毕，接下来遍历右子树）
            {
                treeNodeStack.push(pointer);
                pointer = pointer.left;
            }
            else {
                pointer = treeNodeStack.pop();
                resultList.add(pointer.val);
                if(pointer.right!=null)
                    pointer = pointer.right;
                else
                    pointer = null;

            }
        }
        return resultList;
    }

    public static List<Integer> preOrderTravelSal(TreeNode root)//二叉树的前序遍历，根节点，左子树，右子树
    {
        List<Integer> resultList = new ArrayList<Integer>();
       /* if(root==null)
            return resultList;
        resultList.add(root.val);
        resultList.addAll(preOrderTravelSal(root.left));
        resultList.addAll(preOrderTravelSal(root.right));
        return resultList;*/
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode pointer = root;
        while(pointer!=null||!treeNodeStack.empty())
        {
            if(pointer!=null)
            {
                treeNodeStack.push(pointer);
                resultList.add(pointer.val);
                pointer = pointer.left;
            }else {
                pointer = treeNodeStack.pop().right;
            }
        }
        return resultList;
    }

    public static List<Integer> bacOrderTravelSal(TreeNode root)
    {
        List<Integer> resultList = new ArrayList<Integer>();
        /*if(root==null)
            return resultList;
        resultList.addAll(bacOrderTravelSal(root.right));
        resultList.add(root.val);
        resultList.addAll(bacOrderTravelSal(root.left));
         return resultList;
        */
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode pointer = root;
        while(pointer!=null||!treeNodeStack.empty())
        {
            if(pointer!=null)
            {
                treeNodeStack.push(pointer);
                pointer = pointer.right;
            }else {
                pointer = treeNodeStack.pop();
                resultList.add(pointer.val);
                if(pointer.left!=null)
                    pointer = pointer.left;
                else
                    pointer = null;
            }
        }
        return resultList;

    }

    public static List<Integer> floorOrderTravelSal(TreeNode root)
    {
        List<Integer> resultList = new ArrayList<Integer>();
        if(root!=null)
            return resultList;

        Queue<TreeNode> treeNodeQueue = new ArrayDeque<TreeNode>();
        TreeNode pointer;
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty())
        {
            pointer = treeNodeQueue.poll();
            resultList.add(pointer.val);
            if(pointer.left!=null)
                treeNodeQueue.add(pointer.left);
            if(pointer.right!=null)
                treeNodeQueue.add(pointer.right);
        }
        return resultList;
    }



}
