package com.sohu.yifanshi.test.maxSubArray;

//题目为求一个数组的最大和的子数组。这是一般解法，复杂度为On。
//思路：算法种有两个变量，max记录最大值。sum记录子数组之和。遍历这个数组。没遍历一个数，就将这个数加入sum并于这个数本身比较。如果sum+这个数的和
//比这个数小，那么就将sum重置为这个数本身。若sum+这个数比的和比这个数大，那么就运行sum+=nums[i]。遍历期间记录下最大的sum即为最大的子数组和。
public class MaxSubArray_On {

    public static int maxSubArray(int[] nums) {
        int max = -100000;
        int sum = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {

            if(sum+nums[i]<nums[i])
                sum=nums[i];
            else
                sum+=nums[i];
            if(sum>max)
            {
                max=sum;
            }

        }
        return max;
    }
}
