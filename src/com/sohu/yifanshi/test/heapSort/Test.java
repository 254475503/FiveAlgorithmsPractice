package com.sohu.yifanshi.test.heapSort;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,5,8,9,1,2};//一般储存堆都是从1开始储存，因为0乘以多少都为0，他是没有子结点的。
        heapSortFun heapSortFun = new heapSortFun(nums);
//        heapSortFun.creatHeap(heapSortFun.nums,heapSortFun.nums.length-1);
        heapSortFun.heapSort(heapSortFun.nums);
        for(int i : heapSortFun.nums)
            System.out.print(i+" ");
    }
}
