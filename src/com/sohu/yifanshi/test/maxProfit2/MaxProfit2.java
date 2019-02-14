package com.sohu.yifanshi.test.maxProfit2;

//还是买股票。但是可以进行多次交易，但是同时只能进行一次交易。
public class MaxProfit2 {
    public int maxProfit(int[] prices)
    {
        if( prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        for(int i = 0 ; i < prices.length-1 ; i ++)
        {
            prices[i] = prices[i+1]-prices[i];
            if(prices[i]>0)
                profit+=prices[i];
        }
        return profit;
    }
}
