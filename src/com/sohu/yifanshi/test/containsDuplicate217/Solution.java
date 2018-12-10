package com.sohu.yifanshi.test.containsDuplicate217;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static boolean containsDuplicate(int[] nums)
    {
        if(nums.length==0)
            return false;
        int[] list = new int[16];
        boolean havezero = false;
        list[0] = nums[0];
        if(nums[0]==0)
            havezero = true;
        for(int i = 1 ; i< nums.length ; i++)
        {
            if(nums[i]==0)
            {
                if(havezero==true)
                    return true;
                else
                    havezero = true;
            }
            int minIndex = 0;
            int maxIndex = list.length;
            int j = -1;
            if(nums[i]<list[0])
            {
                sortedAdd(list,0,nums[i],i);
                continue;
            }
            else if(nums[i]==list[0]&&list[j]!=0)
                return true;
            if(nums[i]>list[list.length-1])
            {
                sortedAdd(list,list.length,nums[i],i);
                continue;
            }else if(nums[i]==list[list.length-1]&&list[j]!=0)
            {
                return true;
            }
            for(;minIndex<maxIndex;)
            {
                j = (maxIndex+minIndex)/2;
                if(nums[i]==list[j]&&list[j]!=0)
                {
                    return true;
                }
                else if(nums[i]<list[j])
                    maxIndex = j;
                else if(nums[i]>list[j])
                    minIndex = j+1;
            }
            if(i!=-1)
            {
                if(list[j]==nums[i]&&list[j]!=0)
                    return true;
                else
                    sortedAdd(list,j,nums[i],i);
            }

        }
        return false;
    }

    public static void sortedAdd(int[] nums , int index , int insertNum,int outArrayIndex)
    {
        ensureSizeEnough(outArrayIndex,nums);
        System.arraycopy(nums,index,nums,index+1,nums.length-index);
        nums[index] = insertNum;
    }

    public static boolean ensureSizeEnough(int i,int[] nums)
    {
        try{

            if(!(i+1<nums.length))
                extendCapacity(nums);
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void extendCapacity(int[] nums)
    {
        nums = Arrays.copyOf(nums,nums.length*2);
    }
}
