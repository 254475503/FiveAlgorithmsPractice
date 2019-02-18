package com.sohu.yifanshi.test.findMedianSortedArrays;

public class Test {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,4,5,6};
        int[] nums2 = new int[]{-2,-1};
        FindMedianSortedArrays_mn.findMedianSortedArrays(nums1,nums2);
        System.out.println(FindMedianSortedArrays_logn.findMedian_logn(nums1,nums1.length,nums2,nums2.length));
    }
}
