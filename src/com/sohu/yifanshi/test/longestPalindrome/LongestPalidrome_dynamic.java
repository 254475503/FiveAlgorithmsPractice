package com.sohu.yifanshi.test.longestPalindrome;

public class LongestPalidrome_dynamic {
    public static String longestPalindrome(String s)//动态规划法。所谓动态规划就是把递归过程中的结果记录下来，之后算更大的结果是能用的时候直接使用而不是再算一次！
    {
        char[] chararry = s.toCharArray();
        String longestPalindrome="";
        int maxlen = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];//dp[i][j]表示从i到j是不是回文字符串。是则true
        //如果dp[a][b]是回文序列，同时s[a-1]==s[b+1] 那么dp[a-1][b+1]也为true，他们也是回文字符串。本代码的核心内容就是这个
        for(int i = s.length()-1 ; i >-1 ; i--)//要注意动态规划的顺序，先从小的情况算起。不然可能会出错
        {
            for(int j = s.length()-1 ; j > i-1 ; j--)
            {
                if(j-i<2)
                {
                    dp[i][j]=(chararry[i]==chararry[j]);
                }
                else
                {
                    dp[i][j]=(chararry[i]==chararry[j]&&dp[i+1][j-1]);
                }
                if(dp[i][j]&&(j-i+1)>maxlen)
                {
                    maxlen=(j-i+1);
                    longestPalindrome="";
                    for(int x = i ; x <j+1 ; x ++)
                    {
                        longestPalindrome+=chararry[x];
                    }
                }
            }
        }
        return longestPalindrome;
    }

}
