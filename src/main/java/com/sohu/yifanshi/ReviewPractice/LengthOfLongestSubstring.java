package com.sohu.yifanshi.ReviewPractice;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcdcba"));
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
}
