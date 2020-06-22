package com.sohu.yifanshi.SlidingWindow;

import java.util.HashSet;
import java.util.concurrent.locks.Condition;

public class ContainsNearByDuplicateNums {
    public static void main(String[] args) {
        ContainsNearByDuplicateNums containsNearByDuplicateNums = new ContainsNearByDuplicateNums();
        containsNearByDuplicateNums.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2);
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int start=0,end = 0;
        k = k+1;
        HashSet<Integer> myset = new HashSet<>();
        while (end<nums.length&&myset.size()<k+1)
        {
            Integer n = nums[end];
            if(!myset.contains(n))
            {
                myset.add(n);
            }else {
                return true;
            }
            end++;
        }
        while (end<nums.length)
        {
            myset.remove(nums[start]);
            start++;
            Integer n = nums[end];
            if(!myset.contains(n))
            {
                myset.add(n);
            }else {
                return true;
            }
            end++;
        }
        return false;
    }
}
