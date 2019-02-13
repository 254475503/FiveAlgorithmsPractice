package com.sohu.yifanshi.test.findMedianSortedArrays;

public class FindMedianSortedArrays_logn {
    public static  int findMedian_logn(int vec1[],int n1,int vec2[],int n2){
        int m1 = (n1-1) / 2, m2 = (n2-1) / 2;
        if(n1 == 1)
        {//递归结束条件
            if(n2 == 1)
                return vec1[0] < vec2[0] ? vec1[0] : vec2[0];
            if(n2 % 2 == 0)//如果长的哪一个数组还剩下偶数个数字
            {
                if(vec1[0] >= vec2[m2+1])
                    return vec2[m2+1];//如果短数组剩下的数大于长数组中大的那个中位数则返回长数组中大的中位数
                else if(vec1[0] <= vec2[m2])
                    return vec2[m2];//如果短数组剩下的数小于长数组中晓得那个中位数则返回长数组中小的中位数
                else return vec1[0];//否则返回短数组剩下的数
                //概括来说就是在短数组剩下的数，偶数个数字的长数组中的两个中位数，这三个中位数中寻找中位数
            }
            else//长的那个数组剩下奇数个数的情况则用短数组剩下的那个数和长数组的中位数以及小于中位数的那个数做比较，三者取中位数
            {
                if(vec1[0] >= vec2[m2])
                    return vec2[m2];
                else if(vec1[0] <= vec2[m2-1])
                    return vec2[m2-1];
                else return vec1[0];
            }
        }
        else if(n2 == 1)
        {//递归结束条件
            if(n1 % 2 == 0)
            {
                if(vec2[0] >= vec1[m1+1])
                    return vec1[m1+1];
                else if(vec2[0] <= vec1[m1])
                    return vec1[m1];
                else return vec2[0];
            }
            else
            {
                if(vec2[0] >= vec1[m1])
                    return vec1[m1];
                else if(vec2[0] <= vec1[m1-1])
                    return vec1[m1-1];
                else return vec2[0];
            }
        }
        else
        {
            int cutLen = n1/2 > n2/2 ? n2/2 : n1/2;//注意每次减去短数组的一半，如果数组长度n是奇数，一半是指n-1/2
            if(vec1[m1] == vec2[m2])return vec1[m1];//若两个数组的中位数相等，那么两个数组归并以后中位数肯定不变
            else if(vec1[m1] < vec2[m2])//如果数组1的中位数小于数组2的中位数，那么中位数肯定出现在数组1的后半部分以及数组2的前半部分
                return findMedian_logn(cutvec(vec1,cutLen), n1-cutLen, vec2, n2-cutLen);
            //两个数组在不会出现中位数的部分剔除掉短数组的一半，中位数两边剔除相同个数的其他书数不会影响数组的中位数，这是这个算法的核心
        else
            return findMedian_logn(vec1, n1-cutLen, cutvec(vec2,cutLen), n2-cutLen);
        }
    }

    public static int[] cutvec(int vec[],int cutlen)
    {
        int[] tempvec = new int[vec.length-cutlen];
        for(int i = cutlen ; i < vec.length ; i ++)
        {
            tempvec[i-cutlen] = vec[i];
        }
        return tempvec;
    }
}
