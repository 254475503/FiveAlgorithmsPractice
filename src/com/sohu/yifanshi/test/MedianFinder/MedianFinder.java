package com.sohu.yifanshi.test.MedianFinder;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianFinder {
    public static final int initialSize = 16;
    public int size = 0;
    private int[] myArray;
    private int length;
    private int maxUsefulIndex ;
    public MedianFinder()
    {
        this.size = initialSize;
        this.myArray = new int[initialSize];
        this.length = 0;
        maxUsefulIndex = 0;
    }
    public MedianFinder(int size)
    {
        this.size = size;
        this.myArray = new int[size];
        this.length = 0;
    }

    public int getLength() {
        return length;
    }

    public int[] getMyArray() {
        return myArray;
    }

    public void extendCapacity()
    {
        size *= 2;
        this.myArray = Arrays.copyOf(this.myArray,size);
    }
    public boolean ensureSizeEnough()
    {
        try{
            int i = length+1;
            if(!(i<size))
                extendCapacity();
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void addNum(Integer i)
    {
        if(this.length==0)
        {
            myArray[0] = i;
            length++;
            return;
        }
        if(ensureSizeEnough())
        {
            int insertIndex = halfInsertSearch(i);
            System.arraycopy(myArray,insertIndex,myArray,insertIndex+1,this.length-insertIndex);
            myArray[insertIndex] = i;
            length++;
        }

    }

    public int halfInsertSearch(int num)//输入值为要插入的值，插入的索引为返回值,使用的是二分查找算法寻找应该插入的索引地址。
            //说说我写二分查找碰到的坑把，我自己写的二分查找，最开始是找出查找出比形参要小的那个数的索引，然后插入到他的后面一位，当时我觉得完美
            //直到我碰到了万一这个数要插入到第一位呢？也就是索引0呢？我每次都要插入到返回值的后面一位，那就永远没办法插入到0号位索引。简直是弱智
            //操作。。第二个坑就是二分查找是中位夹逼的策略坑。我最开始出循环的条件是上界与下届的差距不大于1就出循环，每次判断过中位后就把上界
            //或者下界设置到中位上。后来我一想，尼玛中位之前判断过，再判断一次岂不是很浪费？那我就把下届设置为中位+1,上界设置位中位-1这岂不是提高了
            //夹逼的效率？还是naive。因为我在这的返回值是i(下界)所以当我输入的数小于上界，而将上界设置为中位-1时，这个时候如果中位-1刚好时下界，
            //此时就出现了这样一个尴尬的事情。这种情况就是插入的数小于中位但是大于下届，而此时下届与中位相邻，按道理我们应该插入到下届+1也就是中位，
            //但是此时将上界设置成了中位-1的话，直接导致了循环退出。下届依然是比插入值小的哪一个下届，然后就返回了。那么就造成了插入值插入到了比他小的
    //数前面。想要避免这个尴尬的情况，就照着下面的写吧。虽然还没有完全理解，但是能举出这一个例子来就已经足够了。下面就是在判断中位以后，只在
    //插入值大于中位时，让下界变为中位+1，然后返回下届当作插入位置，要么就反过来。只在插入之小于中位时，让上界变为中位-1，然后返回上界当作插入
    //位置。用到的时候直接这么写！别几把问为什么。写出来在说
    {
        int i = 0;
        int j = this.length-1;
        if(num<myArray[0])
            return 0;
        if(num>myArray[j])
            return j+1;
        for(;i<j;)
        {
            int k = (i+j)/2;
            if(num==myArray[k])
                return k;//若找到相同的数就插在相同的数的索引。
            else if(num<myArray[k])
                j = k;
            else if(num>myArray[k])
                i = k+1;
        }
        return i;
    }

    public double findMedian() {
        int currentLength = getLength();
        double median = 0;
        if(currentLength%2==0)
        {
            int preindex = currentLength/2-1;
            int bacindex = preindex+1;
            median = ((double) myArray[preindex]+(double) myArray[bacindex])/2;
        }
        else
            median = myArray[currentLength/2];
        return median;
    }





}
