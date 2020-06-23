package com.sohu.yifanshi.ReviewPractice;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring1("aab"));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxNum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int tempNum = 0;
        for(int i = 0 ; i < s.length();i++)
        {
            char endChar = s.charAt(i);
            int j = stringBuilder.indexOf(String.valueOf(endChar));

            if(j!=-1)
            {
                stringBuilder.append(endChar);
                stringBuilder = stringBuilder.delete(0,j+1);
                tempNum = stringBuilder.length();
            }else {
                stringBuilder.append(endChar);
                tempNum++;
            }
            if(tempNum>maxNum)
                maxNum = tempNum;
        }
        return maxNum;
    }

    public int lengthOfLongestSubstring1(String s) {//滑动窗口的写法
        if(s==null)
            return 0;
        if(s.length()<2)
            return s.length();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        Set<Character> myset = new HashSet<>();

        while (end<s.length())
        {
            Character c = s.charAt(end);
            if(!myset.contains(c))
            {
                myset.add(c);
                if(myset.size()>maxLength)
                    maxLength = myset.size();
            }else {
                while (!c.equals(s.charAt(start)))
                {
                    myset.remove(s.charAt(start));
                    start++;
                }
               start++;
            }
            end++;
        }
        return maxLength;
    }
}
