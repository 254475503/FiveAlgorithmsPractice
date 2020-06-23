package com.sohu.yifanshi.test.PatternMatching;

public class PatternMatching1618 {
    //面试题16.18 给出一个pattern aaabb 和一个字符串dogdogdogcatcat判断字符串是否符合pattern。
    //解法:先确定a与b的长度，然后再根据a，b的长度遍历pattern然后在字符串相应的地方截取出字符串，判断是否相等。需要遍历的次数就是a可能的长度。
    //实现时需要考虑没有a或者b的长度，所以需要在a,b中选出一个存在的主要pattern然后枚举出所有可能的长度，判断是否有一种情况符合。
    public static void main(String[] args) {
        PatternMatching1618 patternMatching1618 = new PatternMatching1618();
        patternMatching1618.patternMatching("bbbaa","xxxxxxy");
    }
    public boolean patternMatching(String pattern, String value) {
        if(pattern.length()==0)
        {
            return value.length()==0;
        }
        int acount = 0;
        for(int i = 0 ; i < pattern.length(); i++)
        {
            if(pattern.charAt(i)=='a')
                acount++;
        }
        int bcount = pattern.length()-acount;
        boolean mainpattern = acount!=0;
        int mainMaxlength = mainpattern?value.length()/acount:value.length()/bcount;
        int maincount = mainpattern?acount:bcount;
        int othercount = pattern.length()-maincount;
        char mainpatternchar = mainpattern?'a':'b';
        boolean flag = false;
        if(othercount!=0)
        {
            for(int i = 0 ; i <=mainMaxlength ; i++)
            {
                if(flag)
                    return flag;
                if((value.length() - maincount*i)%othercount!=0)
                    continue;
                int length_other = (value.length()-(maincount*i))/othercount;
                if(length_other==i&&i==0)
                    continue;
                String main=null,other=null;
                int startIndex = 0;

                for(int l = 0 ; l < pattern.length(); l++)
                {
                    if(pattern.charAt(l)==mainpatternchar)
                    {
                        if(main==null)
                            main = value.substring(startIndex,startIndex+i);
                        else {
                            String temp = value.substring(startIndex,startIndex+i);
                            if(!temp.equals(main))
                            {
                                break;
                            }
                        }
                        startIndex = startIndex+i;
                    }else {
                        if(other==null)
                            other = value.substring(startIndex,startIndex+length_other);
                        else {
                            String temp  = value.substring(startIndex,startIndex+length_other);
                            if(!temp.equals(other))
                            {
                                break;
                            }
                        }
                        startIndex = startIndex+length_other;
                    }
                    if(l==pattern.length()-1)
                        flag = true;
                }
            }
        }else {
            if(value.length()%maincount==0)
            {
                int i = value.length()/maincount;
                String main = null;
                int startIndex = 0;
                for(int j = 0 ; j < maincount; j++)
                {
                    if(j==0)
                        main = value.substring(startIndex,i);
                    else {
                        String temp = value.substring(startIndex,startIndex+i);
                        if(!temp.equals(main))
                            break;

                    }
                    startIndex+=i;
                    if(j==maincount-1)
                        flag = true;
                }
            }
        }

        return flag;
    }
}
