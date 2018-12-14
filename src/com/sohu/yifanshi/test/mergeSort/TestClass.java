package com.sohu.yifanshi.test.mergeSort;

public class TestClass {
    public static void main(String[] args) {
        int[] nums = new int[20000];
        for(int i = 0 ; i <nums.length ; i++)
        {
            nums[i] = (int)(Math.random()*20000);
        }
        System.out.println(System.currentTimeMillis());
        nums = mergeSort.mergeSort(nums,0,nums.length-1);
        System.out.println(System.currentTimeMillis());


    }
}
