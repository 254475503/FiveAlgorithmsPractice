package com.sohu.yifanshi.test;
//718. 最长重复子数组
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//我算是看出来了，没法用常理推出规律的，没法用特殊数据结构去解决的，基本就是用动态规划算法去解决问题的。要么就递归。

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//此题的思路是dp[i][j]为以A[i-1]和B[j-1]结尾的最长子串长度,如果A[i]==B[j],那么dp[i+1][j+1]=dp[i][j]+1。边界时dp[i][0]=0和dp[0][j]=0
public class longestArray {
    public int findLength(int[] A, int[] B) {
        if(A.length==0||B.length==0||A==null||B==null)
            return 0;
        int[][] dp = new int[A.length+1][B.length+1];
        int max = 0;
        //dp[i][j]为以A[i-1]和B[j-1]结尾的最长子串长度
        for(int i = 0 ; i <A.length ; i++)
        {
            for(int j = 0 ; j < B.length ; j++)
            {
                if(i==0||j==0)
                    dp[i][j]=0;
                if(A[i]==B[j])
                    dp[i+1][j+1]=dp[i][j]+1;
                if(dp[i+1][j+1]>max)
                    max = dp[i+1][j+1];
            }

        }
        return max;
    }
}
