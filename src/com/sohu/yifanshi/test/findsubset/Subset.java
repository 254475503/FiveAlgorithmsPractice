package com.sohu.yifanshi.test.findsubset;

import java.util.ArrayList;
import java.util.List;
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//      说明：解集不能包含重复的子集。
//动态规划，原来的数组为[1,2]他的子集有1 2 1，2 [] 那么123的自己就是[1,2]的原子集加上[1，2]原自己中加上自己。如下
//[1，2，3]子集有 1 2 1，2 []（这之前是[1,2]的原子集） 1，3  2，3  1，2，3  3(这里是原子集加上自己)
//所以状态转换就是dp[i] = 2*dp[i-1]
public class Subset {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<List<Integer>>();
        subset.add(0, new ArrayList<>(0));
        for(int i = 0; i < nums.length ; i++)
        {
            List<List<Integer>> newsubset = new ArrayList<>();
            for(int j = 0 ; j < subset.size() ; j ++)
            {
                List<Integer> tempList = new ArrayList<>();
                tempList.addAll(subset.get(j));
                tempList.add(nums[i]);
                newsubset.add(tempList);
            }
            subset.addAll(newsubset);
        }
        return  subset;
    }
}
