package com.sohu.yifanshi.test.generateParenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
//leetcode 22
//列出所有有效括号组合
public class GenerateParentHesis {
    public static List<String> result = new ArrayList<String>();

    public static List<String>  generateParenthesis(int n) {
        String str = "";
        backtracking(n*2,str);
        return result;
    }

    public static void backtracking(int n,String str)
    {
        if(n==0)
        {
            Stack stack = new Stack<>();
            stack.push(str.charAt(0));
            for(int i = 1 ; i < str.length() ; i++)
            {
                if(stack.size()==0)
                    stack.push(str.charAt(i));
                else if(str.charAt(i)==')'&&(char)stack.peek()=='(')
                    stack.pop();
                else
                    stack.push(str.charAt(i));
            }
            if(stack.size()==0)
                result.add(str);
            return;
        }
        str+="(";
        backtracking(n-1,str);
        str=str.substring(0,str.length()-1);
        str+=")";
        backtracking(n-1,str);
    }
}
