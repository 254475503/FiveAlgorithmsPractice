package com.sohu.yifanshi.test.rob213;

import org.junit.Test;

public class solution {
    //将rob198题中一条线的家改为圈。一圈这样的家，不偷相邻的。
    public int dpsolve(int[] nums)
    {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        if(nums.length==3)
            return Math.max(nums[0],Math.max(nums[1],nums[2]));

        int[] array1 = new int[nums.length-1];
        int[] array2 = new int[nums.length-3];

        array1[0] = nums[1];
        array1[1] = Math.max(nums[1],nums[2]);
        array2[0] = nums[2];
        array2[1] = Math.max(nums[2],nums[3]);
        for(int i = 3 ; i < nums.length ; i++)
        {
            array1[i-1] = Math.max(array1[i-1],nums[i]+array1[i-3]);
        }
        for(int i = 4 ; i < nums.length-1 ; i++)
        {
            array2[i-2] = Math.max(array2[i-3],nums[i]+array2[i-4]);
        }

        return Math.max(nums[0]+array2[nums.length-4],array1[nums.length-2]);

    }
    @Test
    public void test()
    {
        System.out.println(dpsolve(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }

}
