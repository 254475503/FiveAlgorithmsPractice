package com.sohu.yifanshi.test.mergeSort;

import com.sohu.yifanshi.test.addTwoNumber.ListNode;

public class mergeSort {

    public static int[] mergeSort(int[] nums, int start, int end)
    {
        int mid = (start+end)/2;
        if(start<end)
        {
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }

        return nums;
    }

    public static void merge(int[] nums, int start, int mid, int end)
    {
        int[] temp = new int[end-start+1];
        int low = start;
        int high = mid+1;
        int k = 0;
        while (!(low>mid) && !(high>end))
        {
            if(nums[low]<nums[high])
            {
                temp[k] = nums[low];
                low++;
                k++;
            }else {
                temp[k] = nums[high];
                high++;
                k++;
            }
        }
        for (;!(low>mid); k++,low++)
            temp[k] = nums[low];
        for(;!(high>end); k++,high++)
            temp[k] = nums[high];
        for(int i = 0; i < temp.length ; i++)
        {
            nums[i+start] = temp[i];
        }
    }

}
