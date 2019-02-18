package com.sohu.yifanshi.test.maxProfit;

public class MaxProfit {
    //我认为的贪心算法，无非就是选出最小值，和最小值以后的最大值，算法复杂度最多On
    public int maxProfit_greedy(int[] prices) {
        int min=0;


        for(int i = 0 ; i < prices.length; i ++)
        {
            if(prices[i]<prices[min])
                min = i;
        }
        int max = min;
        for(int i = max ; i < prices.length ; i ++)
        {
            if(prices[i]>prices[max])
                max = i;
        }
        if(min==max)
            return 0;
        return  prices[max]-prices[min];
    }

    //网上说的动态规划，我觉得并不是。具体原因看我2.13号的复习文档
    public int maxProfit_dp(int[] prices)
    {
        int profit = 0;
        if( prices == null || prices.length == 0)
            return 0;
        int minbuy = prices[0];
        for(int i=1; i < prices.length ; i ++ )
        {
            profit = Math.max(prices[i]-minbuy,profit);//与记录的最小值相减，算出的值与记录的最大值比较，在真正的最小值选取出来之前在做无用运算
            minbuy = Math.min(prices[i],minbuy);//选取最小值
        }
        return profit;
    }

    //转化法。将股票价格表中的后一天价格减去前一天价格，收集为一个数组，这个数组就是股票每天的利润表。我们只需要再这个利润数组中找出他和最大的子数组，
    //就找出了最大利润。这种把求股票价格转化成求最大子数组之和的解法是我认为能算得上是动态规划的解法了。

    public int maxProfit_transfer(int[] prices)
    {
        for(int i = 0 ; i < prices.length-1 ; i ++)
        {
            prices[i] = prices[i+1]-prices[i];
        }

        int profit = prices[0];
        int sum = prices[0];
        for(int i = 1 ; i < prices.length-1 ; i++)
        {
            sum = Math.max(prices[i],prices[i]+sum);
            profit = Math.max(sum,profit);
        }
        return profit;
    }
}
