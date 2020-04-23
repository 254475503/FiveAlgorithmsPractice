package com.sohu.yifanshi.ReviewPractice;

public class MergeSort {//这种写法的归并排序浪费了太多空间，更加完美的归并排序请看 我以抄的
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = mergeSort.mergeSortSolution(new int[]{3,1,5,4,2,2,2,2});
        System.out.println(nums);
    }
    public int[] mergeSortSolution(int[] nums)
    {
       return sort(0,nums.length-1,nums);
    }

    private int[] sort(int i, int i1, int[] nums) {
        if(i==i1)
            return new int[]{nums[i1]};
        int low = i;
        int high = i1;
        int mid = (i+i1)/2;
        int[] nums1 = sort(low,mid,nums);
        int[] nums2 = sort(mid+1,high,nums);
        int[] nums3 = new int[nums1.length+nums2.length];
        int j=0,k=0,l=0;
        while (j<nums1.length&&k<nums2.length)
        {
            if(nums1[j]<nums2[k])
            {
                nums3[l] = nums1[j];
                j++;
            }
            else
            {
                nums3[l] = nums2[k];
                k++;
            }
            l++;
        }
        if(j==nums1.length)
        {
            while (l<nums3.length)
            {
                nums3[l] = nums2[k];
                l++;
                k++;
            }
        }else {
            while (l<nums3.length)
            {
                nums3[l] = nums1[j];
                l++;
                j++;
            }
        }
        return nums3;
    }
}
