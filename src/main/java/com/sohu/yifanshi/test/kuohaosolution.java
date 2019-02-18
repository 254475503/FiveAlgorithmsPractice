package com.sohu.yifanshi.test;

import java.util.Stack;

public class kuohaosolution {
    public static void main(String[] args) {
        String S = "(()()())";
        System.out.println(minAddToMakeValid(S));
    }
    public static int minAddToMakeValid(String S) {
        Stack stack = new Stack();
        char[] chars = S.toCharArray();
        char left = (new String("(")).charAt(0);
        char right = (new String(")")).charAt(0);

        for(int i = 0; i < chars.length ; i ++)
        {
            if(stack.size()==0)
            {
                stack.push(chars[i]);
                continue;
            }
            if((char)stack.peek()==left&&chars[i]==right)
                stack.pop();
            else
                stack.push(chars[i]);
        }
        return stack.size();
    }
}
