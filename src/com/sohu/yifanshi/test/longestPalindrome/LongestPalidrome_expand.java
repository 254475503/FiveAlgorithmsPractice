package com.sohu.yifanshi.test.longestPalindrome;

public class LongestPalidrome_expand {//中心扩散法，循环的从字符串每一个字母向两侧扩散的同时判断是否为回文字符串，超过记录的最大距离则记下来
    public static String longestPalindrome(String s)
    {
        int[] range = new int[2];
        for(int i = 0 ; i < s.length() ; i ++)
        {
            expandFromCenter(s,range,i);
        }
        return s.substring(range[0],range[1]);
    }

    public static void expandFromCenter(String s,int[] range,int i)
    {
        int low =i , high = i;
        while(high<s.length()-1&&s.charAt(high)==s.charAt(high+1))
        {
            high++;
        }
        while (low>0&&high<s.length()-1&&s.charAt(low-1)==s.charAt(high+1))
        {
            low--;
            high++;
        }
        if(high-low>range[1]-range[0])
        {
            range[1]=high+1;//高位本来就是回文字符串的高位下标，但是还要+1的原因是这里用了string.substring方法。这个方法的endindex是开区间，不会作为string一起生成。
            //所以为了把最后一位包括进去要+1
            range[0]=low;
        }
    }
}
