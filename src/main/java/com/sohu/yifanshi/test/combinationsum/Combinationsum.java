package com.sohu.yifanshi.test.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//回溯法练习
//（容我啰嗦地白话下，给你一个正数数组candidate[],一个目标值target，
// 寻找里面所有的不重复组合，让其和等于target，给你[2,3,6,7] 2+2+3=7 ,7=7,所以可能组合为[2,2,3],[7]）
//回溯法套路
//1.定义一个全局的结果集合
//2.定义一个辅助的方法（函数）public void backtracking(int n,int k, List<Integer>list){}，函数的参数按需求添加，
//3.backtracking里面，循环添加原数组中的数字，用来计算选区这一项的情况，用递归调用来当作选区下一项。从递归中结束后，删除这一项再进入下一次循环
//用计算不选取这一项的情况
public class Combinationsum {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<Integer> list = new ArrayList<Integer>();

        backtracking(candidates,7,0,list);

        return result;

    }

    public void backtracking(int[] candidates,int target,int start,List<Integer> list){
        for(int i = start ; i < candidates.length ; i++)
        {
            list.add(candidates[i]);
            if(target<0)
                return ;
            else if(target==0)
                result.add(list);
            backtracking(candidates,target-candidates[i],start+1,list);
            list.remove(list.size()-1);


        }
    }

}
