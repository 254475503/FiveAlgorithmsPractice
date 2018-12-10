package com.sohu.yifanshi.test.MedianFinder;

public class TestClass {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        int[] myArray = new int[]{6,10,2,6,5,0};
        for(int i : myArray)
        {
            medianFinder.addNum(i);
        }
        System.out.println(medianFinder.findMedian());
    }
}
