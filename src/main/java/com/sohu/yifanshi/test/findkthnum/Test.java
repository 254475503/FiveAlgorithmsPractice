package com.sohu.yifanshi.test.findkthnum;

public class Test {
    @org.junit.Test
    public void test()
    {
        int[] nums = new int[]{2,5,4,7,3,1};
        FindKthNum findKthNum = new FindKthNum();
        System.out.println(findKthNum.findKthNum(nums,6));

    }
}
