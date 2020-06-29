package com.sohu.yifanshi.test.BinaryAdd;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.addBinary("1111","1011"));
    }
    public String addBinary(String a, String b) {
        int x = 0 ,y = 0;
        for(int i = a.length()-1;i>=0;i--)
        {
            if(a.charAt(i)=='1')
                x += Math.pow(2,a.length()-1-i);
        }
        for(int i = b.length()-1;i>=0;i--)
        {
            if(b.charAt(i)=='1')
                y+= Math.pow(2,b.length()-1-i);
        }
        while (y!=0)
        {
            int answer = x ^ y;
            int carry = (x&y)<<1;
            x = answer;
            y = carry;
        }
        return  tentobinary(x);
    }
    public String tentobinary(int x )
    {
        StringBuilder stringBuilder = new StringBuilder();
        while (x>1)
        {
            if(x%2==1)
                stringBuilder.append("1");
            else
                stringBuilder.append("0");
            x /=2;
        }
        if(x==1)
            stringBuilder.append("1");
        else stringBuilder.append("0");
        return stringBuilder.reverse().toString();
    }

}
