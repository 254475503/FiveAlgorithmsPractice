package com.sohu.yifanshi.ReviewPractice;

public class CutRopeOne {
    public static void main(String[] args) {
        CutRopeOne cutRopeOne = new CutRopeOne();
        cutRopeOne.cuttingRope1(5);
    }
    public int cuttingRope(int n) {
        if(n==0||n==1)
            return 0%1000000007;
        if(n==2)
            return 1%1000000007;
        if(n==3)
            return 2%1000000007;
        if(n==4)
            return 4%1000000007;
        if(n==5)
            return 6%1000000007;
        if(n==6)
            return 9%1000000007;
        int[] dp = new int[n+1];

        dp[0]=dp[1] = 0%1000000007;

        dp[2] =1%1000000007;

        dp[3] =  2%1000000007;

        dp[4] = 4%1000000007;

        dp[5] = 6%1000000007;

        dp[6] = 9%1000000007;
        for(int i =7 ;i<=n ;i++)
        {
            dp[i] = 3*dp[i-3]%1000000007;
        }
        return dp[n];
    }

    public int cuttingRope1(int n)
    {

        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i = 3 ; i <=n;i++)
        {
            for(int j = 1;j<i;j++)
            {
                dp[i] = Math.max(Math.max(j*(i-j),j*dp[i-j]),dp[i]);
            }

        }
        return dp[n];

    }
}
