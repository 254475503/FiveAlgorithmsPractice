package com.sohu.yifanshi.ReviewPractice;

//剑指offer11 寻找旋转数组中的最小值。
//在脑子中想象出一个递增的曲线。在曲线的中间取值与最后面比较。不难发现旋转后的曲线中间的那个值 如果大于最后的值，那么最小值一定会出现在中间到最后，反之亦然。
public class FindMinInRotateArray {
    public static void main(String[] args) {
        String str = new String();
        str.length();
        FindMinInRotateArray findMinInRotateArray = new FindMinInRotateArray();
        findMinInRotateArray.minArray(new int[]{2,2,2,0,1});
    }
    public int minArray(int[] numbers)
    {
        return findmin(numbers,0,numbers.length-1);
    }

    public int findmin(int[] numbers ,int start,int end)
    {
        while (start!=end)
        {
            int mid = (start+end)/2;
            if(numbers[mid]<numbers[end])
            {
                end = mid;
            }
            else if(numbers[mid]>numbers[end])
            {
                start = mid+1;//这里为什么+1？ num[mid]都大于numbers[end]了 明显不可能时最小啊 最小必在他后面
            }else if(numbers[mid]==numbers[end])//当numbers[mid]==numbers[end]时 我们时没有很好的办法判断旋转书在哪的。但是 end--可以保证缩小范围同时不会把最小值排除在外。
            {
                end--;
            }
        }
        return numbers[start];
    }

}
