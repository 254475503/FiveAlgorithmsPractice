package com.sohu.yifanshi.test.maxSubArray;

import org.junit.Test;

public class MaxSubArray_dp {
    //状态方程 ： max( dp[ i ] )  = getMax(  max( dp[ i -1 ] ) + arr[ i ] ,arr[ i ] ) 。
    // 上面式子的意义是：我们从头开始遍历数组，遍历到数组元素 arr[ i ] 时，连续的最大的和 可能为 max( dp[ i -1 ] ) + arr[ i ] ，
    // 也可能为 arr[ i ] ，做比较即可得出哪个更大，取最大值。时间复杂度为 n 这里的max(dp[i])的意义是包含第i个数的情况下从0到i个数种的最大值。
    //这里的思想其实和另外一个On的思想是一样的。

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        String str = "";
        String maxstr="";
        for(int i = 1 ; i < nums.length ; i ++)
        {
            if(sum+nums[i]>nums[i])
            {
                sum = sum+nums[i];
                str+=" "+nums[i];
            }
            else {
                sum = nums[i];
                str = String.valueOf(nums[i]);
            }
            if(sum>max)
            {
                max = sum;
                maxstr = str;
            }
        }
        System.out.println(maxstr);
        return max;
    }

    @Test
    public void test()
    {
        System.out.println(MaxSubArray_dp.maxSubArray(new int[]{-2,9,-7,-10,1,1,6,1,-7,1,-3,1,5,-10,12,10,-3,-1,5,7,-2,6,-4,7,7}));
    }

}
