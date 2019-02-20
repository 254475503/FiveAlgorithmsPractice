package com.sohu.yifanshi.test.sigleNumber;

import org.junit.Test;

//leetcode136题，只出现奇数次的数字。使用异或运算符。异或运算时将数字转化为二进制，每一位互相运算的操作符。两个数同一位相同，异或出的结果对应的哪一位
// 就是0。不同就是1.所谓同0异1.若是从十进制的角度来看0与任意一个数异或都是这个数本身0^8=8。再二进制的角度来看0^0=0 1^1=0 0^1=1 1^0=1。由此我们可以看出
//本题中所有出现偶数次的数异或的结果必定为0.全部异或到最后就只剩下0和出现奇数次的那个数异或。0与任何数异或都是这个数本身。所以这道题只要将他全部异或就行了。
//这是奇技淫巧啊  面试应该不会考，但是我还是记录下来了。
public class sigleNumber {
    @Test
    public void test()
    {
        int[] nums = new int[]{4,2,2,2,2};
        int result = nums[0];
        for(int i = 1 ; i < nums.length ; i ++)
        {
            result^=nums[i];
            System.out.println(result);
        }

    }
}
