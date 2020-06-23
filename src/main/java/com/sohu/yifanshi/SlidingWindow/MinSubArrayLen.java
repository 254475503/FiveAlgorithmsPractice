package com.sohu.yifanshi.SlidingWindow;

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0,end = 0;
        int temp = 0;
        int min = 0;
        while (end<nums.length)
        {
            temp+=nums[end];
            if(temp>=s)
            {
                if(end == start)
                    return 1;

                while (temp>=s)
                {
                    if((end-start+1)<min||min==0)
                        min = end-start+1;
                    temp-=nums[start];
                    start++;
                }
                if(temp==0)
                    return 1;
            }
            end++;

        }
        return min;
    }
}
