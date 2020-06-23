package com.sohu.yifanshi.test.IsPalindrome;

public class Solution
{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }
    public boolean isPalindrome(String s) {
        int i = 0 , j = s.length()-1;
        while (i<j)
        {
            while (i<=j)
            {
                int x = Integer.valueOf(s.charAt(i));
                if((x>=65&&x<=90)||(x<=122&&x>=97))
                    break;
                i++;
            }
            while (i<=j)
            {
                int x = Integer.valueOf(s.charAt(j));
                if((x>=65&&x<=90)||(x<=122&&x>=97))
                    break;
                j--;
            }
            int x = Integer.valueOf(s.charAt(i)),y = Integer.valueOf(s.charAt(j));
            if(abs(x-y)!=32)
                return false;
            i++;
            j--;
           /* if(i!=j||)*/
        }
        return true;
    }
    Integer abs(Integer a)
    {
        return a>0?a:-a;
    }
}
