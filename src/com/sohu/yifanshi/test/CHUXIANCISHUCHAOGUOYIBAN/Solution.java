package com.sohu.yifanshi.test.CHUXIANCISHUCHAOGUOYIBAN;

//这是无意中看到的一道有意思的题目。给定一个数组，其中一个属出现次数超过了数组长度的一半，求这个数字。
//无语的是我居然第一反应是万一这个数不止一个咋办，那什么挽救你。。。我的智商。。
//常规解法是先排序再取中位数。看见一种有意思的解法是，创建两个变量。一个记录数字，一个记录数字出现次数value。
//遍历这个数组，如果遍历的这个数，与记录的数字相同，则value++；不同的话则value--，若value小于0了则将记录的数字换成使value小于0的这个数。
//遍历到最后若value>0，则说明记录的这个数字出现次数超过一半。若value不大于0则说明没有大于一半的数字。
//然后我就又想出了一个问题，如何找出数组中出现次数最多的数字。用这里的方法显然是行不通的。我好像又做过这个题目，去翻一下
public class Solution {
    public int  mySolution(int[] nums)
    {
        int num=nums[0];
        int value = 1;
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(num==nums[i])
                value++;
            else{
                value--;
                num=nums[i];
            }
        }
        if(value>0)
            return num;
        else
            return 0 ;
    }
}
