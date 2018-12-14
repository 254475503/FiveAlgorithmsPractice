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

}
