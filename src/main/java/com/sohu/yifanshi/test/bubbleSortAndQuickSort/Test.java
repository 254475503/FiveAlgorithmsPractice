package com.sohu.yifanshi.test.bubbleSortAndQuickSort;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{6,2,3,4,5,1};
        Sorts sorts = new Sorts();
        sorts.nums = nums;
        sorts.quickSort(0,5);
        for(int i : sorts.nums)
            System.out.print(i+" ");
    }

    @org.junit.Test
    public void test()
    {
        Sorts sorts = new Sorts();
        sorts.nums = new int[]{3,7,1,2,4,8,6,5};
        sorts.bubblesort_finalpro();
        System.out.println(sorts.nums[0]+""+sorts.nums[1]+""+sorts.nums[2]+""+sorts.nums[3]+""+sorts.nums[4]+""+sorts.nums[5]+""+sorts.nums[6]+""+sorts.nums[7]);

    }
}
