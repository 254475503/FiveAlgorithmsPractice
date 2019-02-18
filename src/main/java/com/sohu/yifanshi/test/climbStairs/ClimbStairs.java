package com.sohu.yifanshi.test.climbStairs;

public class ClimbStairs {
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else{
            dp[0]=0;
            dp[1]=1;
            dp[2]=2;
            for(int i = 3; i < dp.length ; i++)
            {
                dp[i] = dp[i-2]+dp[i-1];
            }
        }
        return dp[n];
    }
}

