package com.sohu.yifanshi.test.perfecNum;

import java.util.ArrayList;
import java.util.List;

public class perfecNum {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        System.out.println(checkePerfectNum(10000000));
        long endTime = System.currentTimeMillis();
        System.out.println("cost time : "+(starTime-endTime));
    }
    public static boolean checkePerfectNum(int num)
    {
        if(num==0)
            return false;
        int sum = 1;
        for(int i = 2; i < (num/2+1)  ; i++)
        {
            if(num%i==0)
                sum+=i;
        }
        if(sum==num)
            return true;
        else
            return false;

    }

}
