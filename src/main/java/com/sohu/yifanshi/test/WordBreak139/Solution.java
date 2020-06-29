package com.sohu.yifanshi.test.WordBreak139;

import java.net.Socket;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("a");
        //list.add("pen");
        System.out.println(solution.wordBreak("a",list));
    }
    /*public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,List<String>> map = new TreeMap<Integer,List<String>>();
        for(String str:wordDict)
        {
          List<String> strings =   map.get(str.length());
          if(strings==null)
          {
              strings = new ArrayList<String>();
              map.put(str.length(),strings);
          }
          strings.add(str);
        }
        Set<Integer> theset = map.keySet();
       for(Integer i : theset)
       {
            if(0+i<s.length())
            {
                for(String str:map.get(i))
                {
                    if(s.substring(0,0+i).equals(str))
                        if(backTracing(s,0+i,theset,map))
                            return true;
                }
            }


       }
       return  false;
    }*/

    private boolean backTracing(String s, int i, Set<Integer> theset, Map<Integer, List<String>> map) {
        if(i==s.length())
            return true;
        for(Integer length :theset )
        {
            if(i+length<=s.length())
            {
                for(String str:map.get(length))
                {
                    if(s.substring(i,i+length).equals(str))
                        if(backTracing(s,i+length,theset,map))
                            return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {//动态规划解法，假设dp[i]位0到i是否能呗分为字典中的单词，那么dp[i]必能被分为dp[j]&&j到i这个单词是否在字典内。其中j到i为一个字典单词的长度。
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
