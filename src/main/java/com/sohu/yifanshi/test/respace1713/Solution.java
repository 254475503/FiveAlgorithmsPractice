package com.sohu.yifanshi.test.respace1713;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
      Solution solution = new Solution();
       // System.out.println(solution.respace(new String[]{"looked","just","like","her","brother"},"jesslookedjustliketimherbrother")) ;
        System.out.println(solution.respace(new String[]{"dodrjo","ez"},"dodrjoejeojqzzdezeodjjrjzj")) ;
        solution.findSubstring("barfoothefoobarman",
                new String[]{"foo","bar"});
    }

    public int respace(String[] dictionary, String sentence) {
        Map<Integer,List<String>> index = new TreeMap<Integer, List<String>>();
        for(int i = 0 ; i < dictionary.length ; i ++)
        {
            List<String> strs = index.get(dictionary[i].length());
            if(strs ==null)
            {
                strs = new ArrayList<String>();
                index.put(dictionary[i].length(),strs);
            }
            strs.add(dictionary[i]);
        }
        int[] dp = new int[sentence.length()];
        for(int i = 0 ; i<sentence.length() ; i ++)
        {
            dp[i] = i+1;
        }
        Set<Integer> keyset = index.keySet();
        for(int i = 0 ; i < sentence.length() ; i++)
        {
            for(Integer wordLength : keyset)
            {
                if(wordLength<=i+1)
                {
                    for(String word:index.get(wordLength))
                    {
                        if(sentence.substring(i-wordLength+1,i+1).equals(word))
                        {
                            if(wordLength!=i+1)
                                dp[i] = Math.min(dp[i],dp[i-wordLength]);
                            else if(wordLength==i+1)
                                dp[i] = 0;
                        }else {
                           if(i==0)
                               dp[i] = 1;
                           else
                               dp[i] = Math.min(dp[i],dp[i-1]+1);
                        }
                    }
                }
            }
        }
        return dp[sentence.length()-1];
    }

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,List<Integer>> wordsSet = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < words.length; i++)
        {
            List<Integer> wordIndex =wordsSet.get(words[i]);
            if(wordIndex==null)
            {
                wordIndex = new ArrayList<Integer>();
                wordsSet.put(words[i],wordIndex);
            }
            wordIndex.add(i);
        }
        int wordLength = words[0].length();
        for(int i = 0 ; i < s.length();i++)
        {
            HashSet<Integer> tempSet = new HashSet<>();
            int startindex = i,floadIndex = i;
            while((floadIndex+wordLength) <= s.length())
            {
                String temp = s.substring(floadIndex,floadIndex+wordLength);
                if(wordsSet.keySet().contains(temp))
                {
                    List<Integer> wordIndex = wordsSet.get(temp);
                    boolean hasLeft = false;
                    for(Integer testIndex:wordIndex)
                    {
                        if(!tempSet.contains(testIndex))
                        {
                            tempSet.add(testIndex);
                            hasLeft = true;
                            break;
                        }
                    }
                    if(!hasLeft)
                    {
                        break;
                    }
                }
                else {
                    break;
                }
                if(tempSet.size()==words.length)
                {
                    result.add(i);
                    break;
                }
                floadIndex+=wordLength;
            }
        }
        return result;
    }
}
