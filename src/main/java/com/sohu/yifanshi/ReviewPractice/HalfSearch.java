package com.sohu.yifanshi.ReviewPractice;

public class HalfSearch {
    public static void main(String[] args) {
        HalfSearch halfSearch = new HalfSearch();

        System.out.println(halfSearch.halfSearchiTheFirstNumberWhichIsBiggerThanTarget(new int[]{1,2,3,3,3,3,4,4,5,7},6));

    }
    public int classicHalfSearch(int[] nums,int target)
    {
        if(nums==null)
            return -1;
        int low = 0;
        int high = nums.length-1;
        while (low<=high)
        {
            int mid = low+((high-low)>>1);
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
            {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }

    public int halfSearchFirstTarget(int[] nums,int target)
    {
        if(nums==null)
            return -1;
        int low = 0;
        int high = nums.length-1;
        while (low<=high)
        {
            int mid = low+((high-low)>>1);
            if(nums[mid]==target)
            {
                if(mid==0||nums[mid-1]!=target)
                    return mid;
                else {
                    high = mid-1;
                }
            } else if(nums[mid]>target)
            {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return  -1;
    }

    public int halfSearchLastTarget(int[] nums,int target)
    {//1 2 3 4 5 6 7 8   8 7 6 5 4 3 2 1
        if(nums==null)
            return -1;
        int low = 0;
        int high = nums.length-1;
        while (low<=high)
        {
            int mid = low+((high-low)>>1);
            if(nums[mid]==target)
            {
                if(mid==nums.length-1||nums[mid+1]!=target)
                    return mid;
                else {
                   low = mid+1;
                }
            } else if(nums[mid]>target)
            {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return  -1;
    }
    public int halfSearchTheMaxNumberWhichIsSmallerThanTarget(int[] nums,int target)
    {
        if(nums==null)
            return -1;
        int low = 0;
        int high = nums.length-1;
        while (low<=high)
        {
            int mid = low+((high-low)>>1);
            if(nums[mid]==target)
            {
                high = mid-1;
            }
            else if(nums[mid]<target)
            {
                if(mid==nums.length-1||nums[mid+1]>=target)
                    return mid;
                else
                    low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }
    public int halfSearchiTheFirstNumberWhichIsBiggerThanTarget(int[] nums,int target)
    {
        if(nums==null)
            return -1;
        int low = 0;
        int high = nums.length-1;
        while (low<=high)
        {
            int mid = low+((high-low)>>1);
            if(nums[mid]==target)
            {
                low = mid+1;
            }
            else if(nums[mid]<target)
            {
                low = mid+1;
            }else {
              if(mid==0||nums[mid-1]<=target)
                  return mid;
              else
                  high = mid-1;

            }
        }
        return -1;
    }
}
