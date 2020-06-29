package com.sohu.yifanshi.test.findkthLargest215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return topk(nums,0,nums.length-1,k);
    }
    public int topk(int[] nums,int start, int end,int k)
    {
        int i = start,j = end;
        int pivotkey = nums[start];
        while(i<j)
        {
            while(nums[j]>=pivotkey&&j>i)
                j--;
            nums[i] = nums[j];
            while(nums[i]<pivotkey&&j>i)
                i++;
            nums[j] = nums[i];
        }
        nums[i] = pivotkey;
        if(i == nums.length-k)
            return nums[i];
        else if(i<nums.length-k)
        {
            return topk(nums,i+1,end,k);
        }else
            return topk(nums,start,i-1,k);
    }
}
