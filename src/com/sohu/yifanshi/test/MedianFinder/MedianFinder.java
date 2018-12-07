package com.sohu.yifanshi.test.MedianFinder;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianFinder {
    public static final int initialSize = 16;
    public int size = 0;
    private int[] myArray;
    private int length;
    public MedianFinder()
    {
        this.size = initialSize;
        this.myArray = new int[initialSize];
        this.length = 0;
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

    public void add(Integer i)
    {
        if(ensureSizeEnough())
        {

        }

    }

    public int halfSearch(int num)//输入值为要插入的值，返回值为插入的位置
    {
        
    }

    public double findMedian() {
        int currentLength = getLength();
        double median = 0;
        if(currentLength%2==0)
        {
            int preindex = currentLength/2-1;
            int bacindex = preindex+1;
            median = (myArray[preindex]+myArray[bacindex])/2;
        }
        else
            median = myArray[currentLength/2];
        return median;
    }





}
