package com.sohu.yifanshi.ReviewPractice;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        if (p.equals(".*"))
            return true;
        return matching(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1);
    }

    

    public boolean matching(char[] schars, char[] pchars, int i, int j) {
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
    }
}
