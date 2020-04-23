package com.sohu.yifanshi.ReviewPractice;

public class PrintNums {
    public int[] printNumbers(int n) {

        int result = 1;
        int x = 10;
        long longn = Long.valueOf(n);
        while(longn>0)
        {
            if((longn&1)==1) result*=x;
            x*=x;
            longn = longn>>1;
        }
        int[] nums = new int[result-1];
        for(int i = 1 ; i<= result-1 ; i++){
            nums[i-1] = i;
        }
        return nums;
    }
}
