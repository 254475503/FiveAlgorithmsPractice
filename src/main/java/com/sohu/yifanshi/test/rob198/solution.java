package com.sohu.yifanshi.test.rob198;

import org.junit.Test;

public class solution {

    public int solve(int index,int[] nums)
    {
        if(index>=nums.length)
            return 0;
        return  Math.max(nums[index]+solve(index+2,nums),solve(index+1,nums));
    }

    public int dpsolve(int[] nums)
    {
        if(null==nums||nums.length==0)
            return 0;
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] dparray = new int[nums.length];
        dparray[nums.length-1] = nums[nums.length-1];
        dparray[nums.length-2] = Math.max(nums[nums.length-2],dparray[nums.length-1]);
        for(int i = nums.length-3 ; i >=0 ;i--)
        {
            dparray[i] = Math.max(nums[i]+dparray[i+2],dparray[i+1]);
        }
        return dparray[0];
    }
    @Test
    public void test()
    {
        System.out.println(new solution().dpsolve(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }
}
