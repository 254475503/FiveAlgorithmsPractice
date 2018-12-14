package com.sohu.yifanshi.test.dividePipeQuestion;

public class DividePipeQuestion {
    public static int[] priceOfPipe = new int[]{0,1,5,8,9,10,17,17,20,24,30,32,37,40,44,45,47,49,52};
    //钢管长度价格表。相应下标对应相应长度。
    //问给定长度的钢管如何切割才能获得最大收益。贪心算法是算出小于该长度的最大性价比的价格，然后每次都分割出
    //性价比最高的那一段。
    //分治算法的思想则是这样的。将每段钢管分成两份，一份长度i不分割直接卖。另一份n-i用以分割，并且求其最优分割收益。
    //n-i那一段继续递归的调用这个算法。以i的值循环的调用这段算法，直到求出其中的最大值。那就是最优解。于是有以下算法
    //这种存粹的递归思想并没有问题。但是我们发现这个代码中有一个很大的缺陷就是。他会进行重复的运算。在这种循环的情况
    //下，算dividePipe(5)必然会去算dividePipe(2),算dividePipe(3)也回去算dividePipe(2)。当钢管的长度低时，这重复
    //运算量很小。影响也不大。但是当钢管变得很大了，那就算法将进行很长的时间，并且很长的时间都在重复运算。
    //于是我们就想，能不能把重复运算的过程给变成只运算一次。于是我们就可以想出，从高向低递归，会重复的运算。但是从低向
    //高运算，则不会。因为，高位最优解都是由地位最优解+一个固定值得到的，我们从低往高算，算高位的时候低位已经算过了
    // 就直接取，无需运算。这样节省了方法栈的空间。这是一种解决方案。
    // 还有一种就解决方案就是将这些运算过的dividePipe的值存起来，下次用到的时候直接取。
    //于是就有了后面两种算法。
    //所谓的动态规划算法就是如此。在递归的过程中，将算过的结果存储。下次使用的时候直接拿出来用，不用再算。
    public static int dividePipe(int n)//求N米钢管如何切割获得最大收益
    {
        if(n==0)
            return 0;
        int q = -1;
        for(int i = 1; i <= n ;i++)
        {
            q =  max(q,priceOfPipe[i] + dividePipe(n-i));
        }
        return q;

    }

    //从上而下的带存储的递归。
    public static int dividePipe(int[] bestPricePipe, int n)
    {
        if(n==0)
            return 0;
        int q = -1;
        for(int i = 1; i <= n; i++)
        {
            if(bestPricePipe[n-i]!=0)
                q = max(q,priceOfPipe[i]+bestPricePipe[n-i]);
            else
                q = max(q,priceOfPipe[i]+dividePipe(bestPricePipe,n-i));
        }
        bestPricePipe[n] = q;
        return q;
    }

    //从地位向高位的运算，无需递归
    public static int dividePipeFromLow(int n)
    {
        int[] bestPricePipe = new int[n+1];
        for(int i = 0 ; i <bestPricePipe.length ; i ++)
            bestPricePipe[i] = 0;
        for(int i = 1 ; i <= n ; i ++)
        {
            int q = -1 ;
            for(int j = 1 ; j <=i  ; j++)
                q = max(q , priceOfPipe[j]+ bestPricePipe[i-j]);
            bestPricePipe[i] = q;
        }
        return bestPricePipe[n];
    }

    private static int max(int q, int i) {
        return i>q ? i : q;
    }
}
