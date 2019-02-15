package com.sohu.yifanshi.test.findsubset;

import java.util.ArrayList;
import java.util.List;

public class Subset_DFS {
    //这道题还可以这么看，一个集合的子集的组成，要么可以遍历每一个数，要么用这个数，要么不用这个数，这种二元性就可以组成一个二叉树，具体的树结构看我
    //2.14-2.15的复习文档。这棵树的叶子节点就是所有的子集。我们可以用深度优先搜索，去搜索吧这个数的叶子节点列出来，就是答案。于是，我们对于这一类问题
    //这一类有选择某种东西，有二元性的，都可以往这种解法上来考虑。

    public static List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();//返回的结果数组
        result.add(new ArrayList<>());//先添加一个为空的子集
        DFS(nums,0,new ArrayList<Integer>(),result);
        return result;
    }

        public static void DFS(int[] nums,int startPoint,List<Integer> tempList,List<List<Integer>> result)
        {
            for(int i = startPoint; i<nums.length ; i++)//用循环来模拟每一个数字的决策
            {
                tempList.add(nums[i]);//再临时数组，加入这个数字
                result.add(new ArrayList<>(tempList));//讲其加入到结果。
                DFS(nums,i+1,tempList,result);//递归，再加入这个数字的基础上再考虑下一个数字
                tempList.remove(tempList.size()-1);//加入这个数字的情况考虑完了，现在将这个数字从临时数组中去掉，进入下一个循环，下一个循环
                //就是下一个数字，所以下一次循环就是不加入这个数字时所有其他子集。

            }
        }
}
