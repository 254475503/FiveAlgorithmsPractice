package com.sohu.yifanshi.test.findkthnum;

//寻找一个数组中第K大的数字。最简单的解是直接用效率最高的排序排序整个数组，然后取出第k个数字。
//但是还有更快的。快速排序一次递归，就会把一个数字放在正确的位置上，那个数字就是pivotkey。所以当我们快速排序的pivotkey最后放在第K位上，那么这个pivotkey
//为我们要找的数字。同时，每轮快排，都会将大于pivotkey的放在右边，小于的放在左边，那么每次结束时，就可以比较一下pivotkey的大小与期望的第几。若期望
//的第k大，小于pivotkey的下标，那么就把左边快排递归，否则快排右边。
public class FindKthNum {
    public int findKthNum(int[] nums, int k)
    {
        int key = quickSort(nums,0,nums.length-1,k);
        return nums[key];
    }

    public int quickSort(int[] nums, int start ,int end,int k)
    {
        int high = end,low = start,pivotkey = nums[start];
        while(low<high)
        {
            while (low<high&&nums[high]>pivotkey)
                high--;
            nums[low] = nums[high];
            while (low<high&&nums[low]<pivotkey)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = pivotkey;
        if(low==(k-1))
            return low;
        else if(low<(k-1))
            return quickSort(nums,low+1,end,k);
        else return quickSort(nums,start,low-1,k);
    }
}
