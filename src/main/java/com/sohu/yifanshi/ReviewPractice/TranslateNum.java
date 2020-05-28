package com.sohu.yifanshi.ReviewPractice;

import com.sohu.yifanshi.test.inOrderTravelSal.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class TranslateNum {
    private static char[] translation = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private Set<String> results = new HashSet<>();
    public int translateNum(int num) {
        StringBuilder stringBuilder = new StringBuilder(num+"");
        backTrace(0,stringBuilder,new StringBuilder());
        return results.size();
    }
    public void backTrace(int startIndex,StringBuilder soruceNum,StringBuilder tempString)
    {
        if(startIndex>=soruceNum.length())
        {
            results.add(tempString.toString());
            return;
        }
        tempString.append(translation[transchartoint(soruceNum.charAt(startIndex))]);
        backTrace(startIndex+1,soruceNum,tempString);
        tempString.deleteCharAt(tempString.length()-1);
        if(startIndex+1<soruceNum.length()&&soruceNum.charAt(startIndex)!='0')
        {
            int num = transchartoint(soruceNum.charAt(startIndex))*10+transchartoint(soruceNum.charAt(startIndex+1));
            if(num<26)
            {
                tempString.append(translation[num]);
                backTrace(startIndex+2,soruceNum,tempString);
                tempString.deleteCharAt(tempString.length()-1);
            }

        }
    }

    public int transchartoint(char num)
    {
        return num-'0';
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum(26));
    }

    public int dynamicProgramming(int num)
    {
        String sourceNum = num+"";
        int[] results = new int[sourceNum.length()];
        results[0] = 1;
        if(sourceNum.charAt(0)!='0'&&sourceNum.length()>1)
        {
            int first = transchartoint(sourceNum.charAt(0))*10+transchartoint(sourceNum.charAt(1));
            if(first<26)
                results[1] = 2;
            else
                results[1] = 1;
        }
        for(int i = 2 ; i < results.length;i++)
        {
            if(sourceNum.charAt(i-1)!='0')
            {
                int first = transchartoint(sourceNum.charAt(i-1))*10+transchartoint(sourceNum.charAt(i));
                if(first<26)
                    results[i] = results[i-1]+results[i-2];
                else
                    results[i] = results[i-1];
            }else {
                results[i] = results[i-1];
            }
        }
        return results[results.length-1];

    }
}
