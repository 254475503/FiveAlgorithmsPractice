package com.sohu.yifanshi.ReviewPractice;

//快速幂算法。
//3的45次方如何快速运算呢？ 45次方可以写成二进制的形式为101101 = (2^5)*1+(2^4)*0+(2^3)*1+(2^2)*1+(2^1)*0+(2^0)*1
//就又可以写成3^(2^5)*1 3^(2^4)*0 3^(2^3)*1 3^(2^2)*1 3^(2^1)*0 3^(2^0)*1
//仔细观察，当n次方的哪一位为0，哪一项就是乘以1.把3看作x 如果循环一次就x*=x的话，那么第一次循环就是x=x^2,x = x^2*x^2 = x^2^2
//第三次循环就是x = x^4*x^4 = x^8 = x^2^3 哦豁 和上面的去掉1和0一样。那么只要判断这一位是不是0，就可以决定这一次时乘以1还是乘以3的2的n次循环次方了。
//这就是快速幂算法。时间复杂度取决于这个数有二进制的几位。那么这个数有几位就是log 以2为底n的对数 所以复杂度时log2n
public class MyPow {
   /* public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(x==0&&n!=0)
            return 0;
        double factor = x;
        if(n<0)
        {
             n = -n-1;
            factor =  x = 1/x;
        }
        for(int i = 0 ; i < n ; i++)
            x*=factor;
        return x;
    }*/
   public double myPow(double x,int n)
   {
       double result = 1;
       long longn = Long.valueOf(n);
       if(x == 0)
           return 0;
       if(longn<0)
       {
           x = 1/x;
           longn = -longn;
       }
       while (longn>0)
       {
           if((longn&1)==1) result*=x;
           x*=x;
           longn = longn>>1;
       }
       return result;
   }
}
