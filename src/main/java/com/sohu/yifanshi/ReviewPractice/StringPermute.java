package com.sohu.yifanshi.ReviewPractice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringPermute {
    public static void main(String[] args) {
        StringPermute permute = new StringPermute();
        permute.permutation("abc");
    }
    public Set<String> strings = new HashSet<>() ;

    public Set<Integer> existSet = new HashSet<>();
    public String[] permutation(String s) {

        char[] chas = s.toCharArray();
        int size = 1;
        for(int i = 1; i <=chas.length; i++)
        {
            size *= i;
        }
        for(int i = 0 ; i < chas.length ; i ++)
        {
            existSet.add(i);
            recur(String.valueOf(chas[i]),chas);
            existSet.remove(i);
        }
        return strings.toArray(new String[strings.size()]);
    }

    public void recur(String string,char[] chars)
    {
        if(existSet.size()==chars.length)
        {
           strings.add(string);

            return;
        }
        for(int i = 0 ; i < chars.length ; i ++)
        {
            if(existSet.contains(i))
                continue;
            else {
                string+=chars[i];
                existSet.add(i);
                recur(string,chars);
                existSet.remove(i);
                string = string.substring(0,string.length()-1);
            }
        }
    }
}
