package com.sohu.yifanshi.test.permute;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums,new ArrayList<Integer>());
        return result;
    }

    public void backtracking(int[] nums, List<Integer> tempList)
    {
        if(tempList.size()==nums.length)
        {
            result.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = 0 ; i < nums.length ; i ++)
            {
                if(tempList.contains(nums[i]))
                    continue;
                else
                {
                    tempList.add(nums[i]);
                    backtracking(nums,tempList);
                    tempList.remove(tempList.size()-1);
                }
            }
        }

    }

}
