package com.sohu.yifanshi.GoogleFooBarChallenge.RemoveDuplicateNNumber;

import java.sql.SQLOutput;
import java.util.*;

public class Solution {

    /*public String solution(int[] nums, int n)
    {
        String result = "";
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++)
        {
            Integer count = map.get(nums[i]);
            if(count==null)
                map.put(nums[i],1);
            else
                map.put(nums[i],count+1);
        }
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        for(Map.Entry entry : entries)
        {
            if((Integer)entry.getValue()<=n)
                result+=entry.getKey()+",";
        }
        if(result.length()!=0)
            result = result.substring(0,result.length()-1);
        return result;
    }*/
    public int[] solution(int[] nums,int n)
    {//不改变原有结构的数组情况下
        HashMap<Integer, List<Integer>> containsMap = new HashMap<>();
        Set<Integer> flagSet = new HashSet<>();
        for(int i = 0 ; i < nums.length;i++)
        {
            List<Integer> list = containsMap.get(nums[i]);
            if(list==null)
            {
                list = new ArrayList<>();
                list.add(i);
                containsMap.put(nums[i],list);
            }else {
                list.add(i);
            }
            if(list.size()==n+1)
            {
                for(int j = 0 ; j < list.size() ; j ++)
                {
                    flagSet.add(list.get(j)) ;
                }
            }
            else if(list.size()>n+1)
                flagSet.add(i);
        }
        if(nums.length==flagSet.size())
            return new int[]{};
        int[] result = new int[nums.length-flagSet.size()];

        int addIndex = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(!flagSet.contains(i))
            {
                result[addIndex] = nums[i];
                addIndex++;
            }
        }
        return result;
    }

}


    /*public String solution(int[] nums,int n)若数组连续则可以
    {
        String result = "";
        for(int i = 0,j=i+1;i<nums.length&&j<nums.length;i=j,j=i+1)
        {
            while (j<nums.length&&nums[i]==nums[j])
                j++;
            if(j-i<=n)
                result+=nums[i]+",";
        }
        if(result.length()!=0)
            result = result.substring(0,result.length()-1);
        return result;
    }*/
