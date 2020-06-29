package com.sohu.yifanshi.test.findkthLargest215;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findKthLargest(new int[]{5,2,4,1,3,6,0},4));
    }
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k+1];
        for(int i = 1 ; i < heap.length ; i ++)
        {
            heap[i] = nums[i-1];
        }
        createheap(heap);
        for(int i = heap.length-1;i<nums.length; i++)
        {
            if(nums[i]>heap[1])
            {
                heap[1] = nums[i];
                fixHeap(heap,1);
            }
        }
        return heap[1];
    }


    private void fixHeap(int[] nums, int i) {
        if(i>(nums.length-1)>>1)
            return;
        int leftsub = i<<1;
        int rightSub = leftsub+1;

        int tempMax = Math.min(nums[i],nums[leftsub])==nums[i]?i:leftsub;
        if(rightSub<nums.length)
            tempMax = Math.min(nums[tempMax],nums[rightSub])==nums[tempMax]?tempMax:rightSub;
        if(tempMax!=i)
        {
            int temp = nums[tempMax];
            nums[tempMax] = nums[i];
            nums[i] = temp;
            fixHeap(nums,tempMax);
        }
    }

    public void createheap(int[] nums)
    {//自底向顶建小顶堆
        for(int i = (nums.length-1)/2;i>0;i--)
        {
            fixHeap(nums, i);
        }
    }
}
