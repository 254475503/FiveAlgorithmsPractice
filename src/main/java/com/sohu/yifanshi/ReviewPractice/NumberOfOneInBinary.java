package com.sohu.yifanshi.ReviewPractice;

public class NumberOfOneInBinary {
    /*public int hammingWeight(int n) {

        int count = 0;
        if(n<1)
            return count;
        while (n>1)
        {
            int i =1;
            for(;i<n;i=i<<1);
            n = n-i>>1;
            count++;
        }
        if(n==1)
            count++;
        return count;
    }*/

    public static void main(String[] args) {
        NumberOfOneInBinary numberOfOneInBinary = new NumberOfOneInBinary();
        numberOfOneInBinary.hammingWeight(00000000000000000000000000001011);
    }
/*    public int hammingWeight(int n)
    {
        int count = 0;
        if(n<1)
            return count;
        while (n>0)
        {
            if(n%10==1)
                count++;
            n/=10;
        }
        return count;
    }*/
public int hammingWeight(int n) {
    int res = 0;
    while(n != 0) {
        res += n & 1;
        n >>>= 1;
    }
    return res;
}

}
