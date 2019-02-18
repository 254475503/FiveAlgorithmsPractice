package com.sohu.yifanshi.test.containsDuplicate217;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //给定一个数组，让你判断其中有没有两个相等的数。
    //我的思路是对于这种乱序的数组判断，最好的办法是先排序在判断。磨刀不误砍柴工，然后我选择的是二分插入排序。即新建一个数组，将原数组使用
    //二分查找插入的位置达到排序的效果。后来我突然发现，二分查找位置的时候，本本身就存在比较的步骤，这个时候就可以比较是否存在相同的数据。这个时候
    //我感觉这是最完美的解决方案，我简直是个天才。因为这样最差的时间复杂度也是nlogn(数组长度位n即循环N次，每重循环中还进行最差时间复杂度位logn的
    // 二分查找，所以最差的时间复杂度为nlogn，最好的时间复杂度为o(1)直接就与头节点或者尾节点，或者中中位节点，或者0相同，就可以直接返回了。)
    //但是我这样的算法，不够简洁，涉及到数组的扩容。现在想想其实也没必要扩容，直接创建一个人和nums一样大的数组不就行了？脑残啊！而且还对空间有
    //需求，需要一个新的数组。精分时刻：我也可以马后炮的认为我的扩容是为了节省空间，嘿嘿嘿。我这个算法在leetcode上运行时间为10ms，当我看见还有
    //2ms的算法的时候，我的内心是崩溃的。当我点进去一看，代码相当之简洁，令人难以置信。代码如下。
    /*public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) break;
                else if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }*/
    //稍微对他的代码坐下记录，如果在数组中这一位比前一位大，那么久跳出内层循环，进行下一次的判断。如果相等，则返回，如果后一位比前一位小，那么就将前一位
    //向前循环，一直循环到j的下标寻到的值大于i下标寻到的值。说明前面没有于他一样的值，直接跳出内层循环，如果在这个过程中遇到相同的值，返回true。
    //这个代码就巧妙的运用了局部的有序去来判断是否存在相同的值。这个算法在数组是升序有序时效率时最高的，数组时降序有序时效率最低。为最差时间为on平方
    //这个代码很难说和我的效率哪一个更高，但是简洁并且巧妙是真的。所以我觉得这个代码更好使。
    public static boolean containsDuplicate(int[] nums)
    {

        if(nums.length==0)//当传入的数组长度为0时，返回false。
            return false;
        int[] list = new int[16];
        boolean havezero = false;//由于新建的数组被初始化时全部为0，所以为了避免与原数组比较时有误解，我们特此设立了一个0是否存在的标识。
        //初始化时0不存在 标志位false。（主要是我的算法会和数组有效的最后一位进行比较，而且是升序的，如果前面全是负数，最后一位是0拿这个0到底是）
        //我插入的还是初始化出来的？不得而知。所以插入0的时候就将标志设置位true。一旦在flag位true，再次插入0时，算法就可以直接返回true(存在重复)了。
        list[0] = nums[0];
        if(nums[0]==0)
            havezero = true;
        for(int i = 1 ; i< nums.length ; i++)
        {
            if(!(i+1<list.length))
                list = extendCapacity(list);//每次循环之前判断一下数组容量。本来我是放在向新数组中添加数据的时候来判断的，但是int数组时基本类型。
            //传入到参数中时值传递，其实就是复制了一个副本给函数调用，我在函数中给数组扩容其实是对副本操作，原数组中并没有改变，扩容是对原数组没有
            //影响的。所以就只能在外面这个地方进行判断扩容与否了。
            if(nums[i]==0)
            {
                if(havezero==true)
                    return true;
                else
                    havezero = true;
            }
            int minIndex = 0;
            int maxIndex = i-1;
            int j = -1;
            if(nums[i]<list[0])//若插入的数比数组第一个小，直接插入到0号下标无需查找
            {
                sortedAdd(list,0,nums[i],i);
                continue;
            }
            else if(nums[i]==list[0]&&list[0]!=0)//等于的话直接返回
                return true;

            if(nums[i]>list[i-1])//插入的数比数组最后一个大，直接插入到后面一个位置
            {
                sortedAdd(list,i,nums[i],i);
                continue;
            }else if(nums[i]==list[i-1]&&list[i-1]!=0)//等于的话直接返回
            {
                return true;
            }

            for(;minIndex<maxIndex;)//二分查找
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

            if(list[j]==nums[i]&&list[j]!=0)//若二分查找出来的下标与插入的数相等，直接返回
                return true;
            else
                sortedAdd(list,j,nums[i],i);//不等就插入


        }
        return false;
    }

    public static void sortedAdd(int[] nums , int index , int insertNum,int outArrayIndex)
    {

        System.arraycopy(nums,index,nums,index+1,outArrayIndex-index);
        nums[index] = insertNum;
    }



    public static int[] extendCapacity(int[] nums)
    {
        return Arrays.copyOf(nums,nums.length*2);
    }
}
