package com.sohu.yifanshi.test;

import java.util.Arrays;
import java.util.Stack;

public class kuohaosolution {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
        kuohaosolution kuohaosolution = new kuohaosolution();
        kuohaosolution.numSubmat(nums);
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
    public int numSubmat(int[][] mat) {
        int res = 0;
        for(int i = 0; i <mat.length; i++)
        {
            res += oneline(mat[i]);
            int[] temp = Arrays.copyOf(mat[i],mat[i].length);
            for(int j = i+1;j<mat.length ; j++)
            {
                for(int k = 0 ; k < mat[0].length ; k++)
                {
                    temp[k] &= mat[j][k];
                }
                res+=oneline(temp);
            }
        }
        return res;
    }
    public int oneline(int[] nums)
    {
        int temp = 0;
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i]==1){
                temp++;
            }
            if(nums[i]==0)
            {
                res+=temp*(temp+1)/2;
                temp = 0;
            }
        }
        return temp==0?res:res+(temp+1)*temp/2;
    }
}
