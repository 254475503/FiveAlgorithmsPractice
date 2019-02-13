package com.sohu.yifanshi.test.findMedianSortedArrays;

public class FindMedianSortedArrays_mn {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        double midnum;
        while (i<nums1.length&&j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                nums[k] = nums1[i];
                k++;
                i++;
            }
            else
            {
                nums[k] = nums2[j];
                k++;
                j++;
            }
        }
        if(i==nums1.length)
        {
            while (j<nums2.length)
            {
                nums[k] = nums2[j];
                k++;
                j++;
            }
        }
        else {
            while (i<nums1.length)
            {
                nums[k] = nums1[i];
                k++;
                i++;
            }
        }
        if(nums.length%2==0)
        {
            midnum = ((double) nums[nums.length/2]+(double) nums[nums.length/2-1])/2;
        }
        else {
            midnum = (double) nums[nums.length/2];
        }
        return midnum;
    }
}
