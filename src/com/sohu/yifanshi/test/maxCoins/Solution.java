package com.sohu.yifanshi.test.maxCoins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*
* 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100*/
public class Solution {
    public static int maxCoins(int[] nums)
    {
        List<Integer> list = new ArrayList<Integer>();
        //将nums初始化位一个list，方便元素的删除。
        list.add(0,1);
        for(int i = 0 ;i < nums.length ; i ++)
        {
            if(nums[i]==0)
                return 0;
            list.add(i+1,nums[i]);

        }
        list.add(1);
        return maxCoins(list);
    }

    //每次戳气球
    public static int maxCoins(List<Integer> list)
    {
        if(list.size()==3)
            return list.get(1);
        else if(list.size()<3)
            return 0;
        int q = -1;
        for(int i = 1; i < list.size()-1 ; i ++)
        {
            int temp = list.get(i-1)*list.get(i)*list.get(i+1);
            List<Integer> tempList =new ArrayList<>(list);
            tempList.remove(i);
            q = max(q,temp+maxCoins(tempList));
        }
        return q;
    }

    public static int max(int i ,int j)
    {
        return i>j? i : j;
    }
}
