package com.sohu.yifanshi.test.FirstMissingPositive;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*public int firstMissingPositive(int[] nums) {//hash法
        Set<Integer> theset = new HashSet();
        for(int i =0 ; i <nums.length;i++)
        {
            if(nums[i]>0)
                theset.add(nums[i]);
        }
        for(int i = 1 ; i <= nums.length ; i++)
        {
            if(!theset.contains(i))
                return i;
        }
        return nums.length+1;
    }*/
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.firstMissingPositive(new int[]{3,4,-1,1});
    }
    public int firstMissingPositive(int[] nums)//替换法
    {
       for(int i = 0 ; i < nums.length ; i++)
       {
           while (nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i])
           {
               int temp = nums[nums[i]-1];
               nums[nums[i]-1] = nums[i];
               nums[i] = temp;
           }

       }
       int k = 0;
       for(int i = 0 ; i < nums.length ; i++)
       {
           if(nums[i]!=i+1)
               return i+1;
           else k++;
       }
       return  k+1;
    }
}
