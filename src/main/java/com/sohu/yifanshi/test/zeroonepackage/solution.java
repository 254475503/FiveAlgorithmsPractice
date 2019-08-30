package com.sohu.yifanshi.test.zeroonepackage;

import org.junit.Test;

public class solution {
      int[] value = {0,8, 10, 6, 3, 7, 2};
     int[] weight = {0,4, 6, 2, 2, 5, 1};
     int[][] dparray = new int[7][13];

    public  int solve(int i,int va,int tempvalue)
    {
        if(i>=value.length)
            return 0;
        if(va<weight[i])
            return solve(i+1,va,tempvalue);
        else
        {
            return Math.max(value[i]+solve(i+1,va-weight[i],tempvalue+value[i]),
                    solve(i+1,va,tempvalue));
        }
    }

    public int dparray_solve()
    {
        for(int i = 0 ; i < 7 ; i++)
        {
            dparray[i][0] = 0;

        }
        for(int i = 0 ; i < 13 ; i++)
            dparray[0][i] = 0;

        for(int i = 1; i <7 ; i ++)
        {
            for(int j = 1 ; j < 13 ; j ++ )
            {
                if(j<weight[i])
                {
                    dparray[i][j] = dparray[i-1][j];
                }
                else
                dparray[i][j] = Math.max(dparray[i-1][j],dparray[i-1][j-weight[i]]+value[i]);
            }
        }

        System.out.println(dparray[6][12]);
        return 0;
    }


    @Test
    public void test()
    {
        System.out.println(new solution().solve(0,  12,0));
        System.out.println(dparray_solve());
    }
}
