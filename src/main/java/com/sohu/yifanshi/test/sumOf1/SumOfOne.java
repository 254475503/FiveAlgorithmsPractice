package com.sohu.yifanshi.test.sumOf1;

import org.junit.Test;

import java.util.ArrayList;

public class SumOfOne implements Runnable {


    public int solution(int n)
    {

        return 0;
    }


    @Test
    public void test()
    {

        int temp = 12;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(temp>0)
        {
            list.add(temp%10);
            temp=temp/10;
        }
        int result = 0;
        while(list.size()>0)
        {
            Integer i = list.get(list.size()-1);
            if(i!=0)
            {
                result+= i*(list.size()-1)*Math.pow(10,list.size()-2)+1;
            }
            list.remove(list.size()-1);
        }
        System.out.println(result);
    }

    @Override
    public void run() {

    }
}
