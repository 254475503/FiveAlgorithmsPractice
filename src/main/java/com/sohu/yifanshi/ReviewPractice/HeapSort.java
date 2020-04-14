package com.sohu.yifanshi.ReviewPractice;

public class HeapSort {

    //堆排序的大概流程，将数放进一个数组中，这个数组下标位0的空间不存数，因为0*2还是0，他不好代表一个数的根节点。
    //将数组下表从1到最后一位开始建堆，建堆其实就是从最下面的非叶子节点开始，自底向顶进行堆的调整。最下面最左侧的非叶子节点的下表怎么算？ nums.length/2就完事。非常神奇
    //堆的调整：将子节点与根节点进行比较，若跟节点不是最大或者最小，那么将根节点与最大或者最小的那个子节点的值进行交换，发生交换的子节点作为根节点，继续进行堆的调整
    //建堆结束以后，下标位1 的值，必定是整个数组最大或者最小的，此时将这个下表位1的值与数组中最后一位的值进行交换，再将最后1位排除在外，以下标为1的数为根节点，进行新的堆的调整。
    //如此往复，直到剩下的堆越来越小，只剩下一个根节点，其他的节点都被排除在外，堆排序也就结束了
    public void sort(int[]nums)
    {
        createHeap(nums);
        int tempNum = nums[1];
        nums[1] = nums[nums.length-1];
        nums[nums.length-1] = tempNum;
        for(int i = nums.length-2;i>1;i--)//i>1是因为只需要把除了第一位所有的位都进行堆排序了那么第一位自然也是排序的。
        {
            heapRefix(nums,i,1);
            int tempNum1 = nums[1];//其实可以进到循环以后再进行建堆以后的第一次根节点与尾节点的交换。那样的话只需要把交换逻辑放到heaprefix的上面，并且把nums.length-2变为-1
            nums[1] = nums[i];
            nums[i] = tempNum1;
        }
    }

    public void createHeap(int[]nums)
    {
        for(int i = nums.length/2;i>0;i--)//因为堆的调整是递归的，一旦发生了根节点与子节点的交换，子节点会重新作为根节点进行堆调整，所以只要自底向顶进行堆调整，最后建出来的一定是一个堆。
        {
            heapRefix(nums,nums.length-1,i);
        }
    }
    public int[] heapRefix(int[] nums,int size,int rootNode)//降序排列
    {
        int leftSon = rootNode*2;
        int rightSon = rootNode*2+1;
        if(leftSon>size)
            return nums;
        int largeNum = leftSon;
        if(rightSon<size)
            largeNum = nums[largeNum]>nums[rightSon]?largeNum:rightSon;
        if(nums[largeNum]>nums[rootNode])
        {
            int tempNum = nums[largeNum];
            nums[largeNum] = nums[rootNode];
            nums[rootNode] = tempNum;
            heapRefix(nums,size,largeNum);
        }
        return nums;
    }
}
