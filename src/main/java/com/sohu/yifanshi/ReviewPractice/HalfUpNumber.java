package com.sohu.yifanshi.ReviewPractice;

public class HalfUpNumber {//摩尔投票法！
    public int majorityElement(int[] nums) {
        Integer i = null;
        long count = 0;
        for(int j = 0 ; j < nums.length ; j ++)
        {
            if(null==i)
            {
                i = new Integer(nums[j]);
                count++;
            }
            else {
                if(i.equals(nums[j]))
                {
                    count++;
                }else {
                    count--;
                    if(count==0)
                        i = null;
                }
            }
        }
        return i;
    }
    public static void main(String[] args) {
        Integer i = new Integer(1);
        int j  = 1;
        System.out.println(i.equals(j));
    }
}
