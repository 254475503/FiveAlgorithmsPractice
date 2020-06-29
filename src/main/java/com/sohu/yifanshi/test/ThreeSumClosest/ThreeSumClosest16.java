package com.sohu.yifanshi.test.ThreeSumClosest;

public class ThreeSumClosest16 {
    private int target ;
    private int result;
    private int temp1 = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ThreeSumClosest16 threeSumClosest16 = new ThreeSumClosest16();
        System.out.println(threeSumClosest16.threeSumClosest(new int[]{-1,2,1,-4},1));
    }
    public int threeSumClosest(int[] nums, int target) {
        this.target = target;
        if(nums.length<3)
            return 0;
        backTrace(nums,0,3,0);
        return result;
    }
    public void backTrace(int[] nums,int start,int maxsize,int cache)
    {
        if(maxsize<1||start>=nums.length)
            return;
        for(int i = start;i<nums.length ; i++)
        {
            if(maxsize!=1)
                backTrace(nums,i+1,maxsize-1,cache+nums[i]);
            else
                compareTarget(cache+nums[i]);
        }
    }

    public void compareTarget(int cache)
    {
        int temp = cache-target>0?cache-target:target-cache;
        if(temp<temp1)
        {
            result = cache;
            temp1 = temp;
        }
    }

}
