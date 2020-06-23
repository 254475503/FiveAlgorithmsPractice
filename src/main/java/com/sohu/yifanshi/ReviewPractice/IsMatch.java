package com.sohu.yifanshi.ReviewPractice;

public class IsMatch {
    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        isMatch.isMatch("mississippi","mis*is*ip*.");
    }
    public boolean isMatch(String s, String p) {
        if (p.equals(".*"))
            return true;
        //return matching(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1);
        return matching(s,p);
    }

    

   /* public boolean matching(char[] schars, char[] pchars, int i, int j) {
        if(i<0)
        {
            if(j<0)
                return true;
            if(pchars[j]=='*')
           {
               return matching(schars,pchars,i,j-2);
           }else
               return false;
        }
        if ( i >=0 && j <0)
            return false;

        if (pchars[j] == '.' || pchars[j] == schars[i])
            return matching(schars, pchars, i - 1, j - 1);
        else if (pchars[j] == '*') {
            if (j == 0)//不可能出现的情况
                return false;

            if (pchars[j - 1] == schars[i]) {
                return matching(schars, pchars, i-1, j );
            } else if (pchars[j - 1] == '.') {
                return matching(schars, pchars, i-1, j );
            } else
               return matching(schars,pchars,i,j-2);

        } else {
            return false;
        }
    }*/

    public boolean matching(String s,String p)
    {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 0 ; i < dp.length ; i ++)
        {
            for(int j = 1 ; j < dp[0].length ;j++)
            {
                if(p.charAt(j-1)!='*')
                {
                    if(matches(s,p,i,j))
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }else
                        dp[i][j] = false;

                }

                else {
                    if(matches(s,p,i,j-1))
                    {
                        dp[i][j] = (dp[i-1][j]||dp[i][j-2]);
                    }else
                        dp[i][j] = dp[i][j-2];

                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean matches(String s,String p ,int i, int j)
    {
        if(i==0)
            return false;
        if(p.charAt(j-1)=='.')
            return true;
        else if(s.charAt(i-1)==p.charAt(j-1))
            return true;
        return false;
    }

}
