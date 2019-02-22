package com.sohu.yifanshi.test.bubbleSortAndQuickSort;

public class Sorts {
    public int[] nums;

    public void bubbleSort()
    {
        for(int i = 0 ; i < nums.length ; i ++)
        {
            for(int j = 0 ; j < nums.length - 1 ; j++)
            {
                if(nums[j]<nums[j+1])
                {
                    nums[j] += nums[j+1];
                    nums[j+1] = nums[j] - nums[j+1];
                    nums[j] -= nums[j+1];
                }
            }
        }
    }


    public void bubbleSort_pro()
    {

        for(int i = 0 ; i < nums.length ; i ++)
            for(int j = 0 ; j < nums.length-1-i ; j ++)
            {
                if(nums[j]<nums[j+1])
                {
                    nums[j] += nums[j+1];
                    nums[j+1] = nums[j] - nums[j+1];
                    nums[j] -= nums[j+1];

                }
            }
    }
    public void bubblesort_finalpro()
    {
        int mark = 0;//用mark位记录最后一次进行换位置的地方，说明那个位位置之后的数组都是有序的，就不需要排序了。
        int i  = 0;
        while(i<nums.length)
        {
            for(int j = 0 ; j < nums.length - 1 - i ; j ++){
                if(nums[j]<nums[j+1])
                {
                    nums[j] += nums[j+1];
                    nums[j+1] = nums[j] - nums[j+1];
                    nums[j] -= nums[j+1];
                    mark = nums.length-(j+1);
                }
            }

            if(i==mark)
                i = nums.length;
            else
                i = mark;
        }


    }

    //快速排序，排序之前选取一个目标值，(默认升序排序)把所有小于这个值的值放在他的前面，把所有大于他的值放在他的后面
    public void quickSort(int start,int end)
    {
        //定义两个指针，一个指向数组起点，一个指向终点。
        int low = start;
        int high = end;
        //若low大于high说明就return，设定递归界。
        if(low>=high)
            return;
        //确定没有递归出界，再将数组的第一位设置位关键值。
        int pivotkey = nums[start];

        while (low<high)
        {
            //在这里是有讲究的，首先我们把pivotkey设置为了数组的起始值，其次按照我们这样循环到了一个不符合条件的直接
            //把这个赋给另外一个，我看见这个代码第一反应就是可能会造成值的丢失。第一个被覆盖掉的会丢失。但是这个算法
            //把数组首位用pivotkey存下来了。那我们就必须保证第一个被覆盖掉的值必须是pivotkey中存在的值被。这个算法正
            //是这么做的。但是我们这个丢失的key即使存下来了也不再数组中了。我们要怎样把这个关键值，正确的插入到数组中呢？
            //这个算法也很精妙的想到了。我们推出这个循环的时候是low=high的时候，也是我们已经把大于关键值的值向右放置，
            //小于这个关键值的值向左放置完毕的时候。那么很明显的low与high重合的地方就是我们要放置pivotkey的位置了
            while (low<high && nums[high]>=pivotkey)
                high--;
            nums[low] = nums[high];
            while (low<high && nums[low]<=pivotkey)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = pivotkey;//放置pivotkey
        //这一次快速排序以后，保证的是pivotkey左边是比她小的，右边是比她大的。我们在递归的，将pivotkey的左右进行快速排序
        //最后就是一个有序的数组了。
        quickSort(start,low-1);
        quickSort(low+1,end);
    }

}
