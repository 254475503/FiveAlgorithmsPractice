package com.sohu.yifanshi.test.maxCoins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*
* 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100*/
public class Solution {
    private  int[][] dp;
    public static int maxCoins(int[] nums)
    {
        List<Integer> list = new ArrayList<Integer>();
        //将nums初始化位一个list，方便元素的删除。
        list.add(0,1);
        for(int i = 0 ;i < nums.length ; i ++)
        {
            list.add(i+1,nums[i]);

        }
        list.add(1);
        return maxCoins(list);
    }

    //每次戳气球
    public static int maxCoins(List<Integer> list)
    {
        if(list.size()==3)
            return list.get(1);
        else if(list.size()<3)
            return 0;
        int q = -1;
        for(int i = 1; i < list.size()-1 ; i ++)
        {
            int temp = list.get(i-1)*list.get(i)*list.get(i+1);
            List<Integer> tempList =new ArrayList<Integer>(list);
            tempList.remove(i);
            q = max(q,temp+maxCoins(tempList));
        }
        return q;
    }

    public static int max(int i ,int j)
    {
        return i>j? i : j;
    }

    public int maxCoin(int[] nums)
    {
        this.dp = new int[nums.length+2][nums.length+2];
        for(int i = 1; i < nums.length+1 ; i ++)
        {
            dp[i][i] = nums[i-1];
        }
        for(int i = 1 ; i< nums.length ; i ++)
        {
            dp[i][i+1] = nums[i-1]*nums[i]+Math.max(nums[i],nums[i-1]);
        }
        dp[0][0] = dp[nums.length+1][nums.length+1] = 1;
        dp[0][1] = nums[0];
        dp[nums.length][nums.length+1] = nums[nums.length-1];
       for(int i = 2 ; i < nums.length ;i++)
       {
           for(int j = 1 ; j <= nums.length - i ; j++)
           {
               int temp = Integer.MIN_VALUE;
               for(int k = j; k <= j+i; k++)
               {
                   temp = Math.max(nums[k-1]*getnum(k-2,nums)*getnum(k,nums)+calculate(j,k-1)+calculate(k+1,j+i),temp);
               }
               dp[j][j+i] = temp;
           }
       }
       return dp[1][nums.length];
    }
    public int getnum(int i ,int[] nums)
    {
        if(i==-1||i==nums.length)
            return 1;
        else
            return nums[i];
    }

    public int calculate(int i , int j)
    {
        if(i>j)
            return 0;
        else
            return dp[i][j];
    }


}
