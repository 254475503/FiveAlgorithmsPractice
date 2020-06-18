package com.sohu.yifanshi.test.RecoverFromPreorder;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import java.util.Stack;

public class RecoverFromPreOrdeer {
    public static void main(String[] args) {
        String s = "1-401--349---90--88";
        RecoverFromPreOrdeer recoverFromPreOrdeer = new RecoverFromPreOrdeer();
        recoverFromPreOrdeer.recoverFromPreorder(s);
    }
    private String s ;

    public TreeNode recoverFromPreorder(String S) {
        s = S;
        Stack<TreeNode> op_stack = new Stack<>();
        int lastcount = 0;
        int i = 0;
        while (i<S.length()&&S.charAt(i)!='-')
        {
            i++;
        }
        TreeNode rootNode = new TreeNode(getNumber(0,i));
        op_stack .push(rootNode);
        while (i<S.length()) {
            int count = 0;
            while (i < S.length()&& S.charAt(i) == '-') {
                count++;
                i++;
            }
            int x = i;
            while (i<S.length()&&S.charAt(i)!='-')
            {
                i++;
            }
            x = getNumber(x,i);
            if (count > lastcount) {
                TreeNode newNode = new TreeNode(x);
                if(op_stack.peek().left!=null)
                    op_stack.peek().right = newNode;
                else
                    op_stack.peek().left = newNode;
                op_stack.push(newNode);
                lastcount = count;
            } else if (count <= lastcount)
            {
                TreeNode newNode = new TreeNode(x);
                int j = lastcount-count+1;
                while (j>0)
                {
                    op_stack.pop();
                    lastcount--;
                    j--;
                }
                op_stack.peek().right = newNode;
                op_stack.push(newNode);
                lastcount++;
            }
        }

        return  rootNode;

    }

    private Integer getNumber (int i,int j)
    {
        return Integer.valueOf(s.substring(i,j));
    }
}
