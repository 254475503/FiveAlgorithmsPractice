package com.sohu.yifanshi.test.searchRotateList;
//搜索旋转数组
/*假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。*/
//对于这样选转的数组，我们将他所有选转结果列出来后发现，只要中间值大于最一位的值，那么从中间到最后一位就是有序的，else从中间到第一位是有序的。
//我们可以每次都通过这一性质来将目标值来和有序数组的数组头和尾进行比较，就可以发现目标值是否在这个有序数组中。若在，但是没找出来，则用这一部分有序的
//进行下一次二分查找，若不在，则用另外一部分进行二分查找。
//推荐去复习MedianFinder，寻找无序数组的中位数练习，我用二分查找的插入方式排序数组寻找中位数
//以及containduplicate，寻找数组中相同的数字。里面也是用二分查找插入的方式去排序寻找，但是还有一个更简洁的，利用局部有序的方法去寻找的，但是时间复杂度不稳定。
public class SearchRotateList {
    public int search(int[] nums, int target)
    {
            int low = 0 ;
            int high = nums.length-1;
            while(low<high||low==high)
            {
                int mid = (low+high)/2;
                if(nums[mid]==target)
                    return mid;
                else if(nums[mid]<nums[high])
                {
                    if(nums[high]==target)
                        return high;
                    else if(nums[mid]<target&&nums[high]>target)
                        low = mid+1;
                    else
                        high = mid-1;
                }
                else {
                    if(nums[low]==target)
                        return low;
                    else if(nums[low]<target&&nums[mid]>target)
                        high = mid-1;
                    else
                        low = mid+1;
                }
            }
            return -1;

    }
}
