package com.sohu.yifanshi.ReviewPractice;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FindNthdigit {
    public int findNthDigit(int n) {
        LinkedList<Integer> mylist[];
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.减去前面所有数位所占的位数。i位数所占位数公式位9*i*10(i-1)次方
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        long num = start + (n - 1) / digit; // 2.减去前面所有的位数，剩下的n就是i位数开始以后往后算的位数了，如何定位n在那个数上？就是这个公式
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.使用string来定位是这个数的第几位。
    }

}
