package com.sohu.yifanshi.test.longestValidParentheses32;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()(())"));
    }
    public int longestValidParentheses(String s) {
       Stack<Integer> stack = new Stack<>();
       boolean[] isValid = new boolean[s.length()];
       for(int i = 0 ; i < s.length() ;i++)
       {
            if(s.charAt(i)=='(')
                stack.push(i);
            else {
                if(stack.isEmpty() || s.charAt(stack.peek())==')')
                    stack.push(i);
                else if(s.charAt(stack.peek())=='(')
                {
                    isValid[stack.peek()]=true;
                    isValid[i] = true;
                    stack.pop();
                }
            }
       }
       int temp = 0;
       int max = 0;
       for(int i = 0 ; i < isValid.length ; i++)
       {
           if(isValid[i])
           {
               temp++;
           }else {
               temp = 0;
           }
           max = max>temp?max:temp;
       }
       return  max;
    }

    /*public int longestValidParentheses(String s) {//更简单的写法，栈底保存一个未被匹配的右括号下标。 每次匹配了，可以根据当前右括号下标减去栈顶的下标来计算这一次括号的长度。若当前是右括号，且发现只剩下栈底元素了，那就把当前下标当作栈底存起来然后继续匹配。
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }*/

}
