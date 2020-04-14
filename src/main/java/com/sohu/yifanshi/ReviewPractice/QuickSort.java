package com.sohu.yifanshi.ReviewPractice;

public class QuickSort {
    public static  void  quickSort(int[] randomList,int start,int end)
    {
        int low = start;
        int high = end;
        if(low>=high)
             return ;
        int pivotKey = randomList[low];
        while (low<high)
        {
            while (low<high&&randomList[high]>=pivotKey)
                high--;
            randomList[low] = randomList[high];
            while (low<high&&randomList[low]<=pivotKey)
                low++;
            randomList[high] = randomList[low];
        }
        randomList[low] = pivotKey;
        quickSort(randomList,start,low-1);
        quickSort(randomList,low+1,end);
    }

    public static void main(String[] args) {
        int[] nums = {1,8,8,7,9,8,3,2,8,6,5};
        quickSort(nums,0,nums.length-1);
       for(int i = 0 ; i < nums.length ; i ++)
       {
           System.out.println(nums[i]);
       }
    }
}
