package com.sohu.yifanshi.test.pushDominoes838;

public class Solution {
    public static String pushDominoes(String dominoes)
    {//重点分析R后面x跟了个L
        char[] charArray = dominoes.toCharArray();
        int lastEndPlace = 0;
        for(int i = 0 ; i < charArray.length ; i++)
        {
            if(charArray[i]=='L')
            {

                for(int j = lastEndPlace ; j<i ; j++)
                    charArray[j] = 'L';
                lastEndPlace = i;
            }
            else if(charArray[i]=='R')
            {
                int k = i+1;
                int placeOfNextL = 0;
                for(;k<charArray.length;k++ )
                {
                    if(charArray[k]=='R')
                    {
                        for(int a = i+1 ; a < k ; a++)
                        {
                            charArray[a] = 'R';
                        }
                        i = k;
                    }
                    else if(charArray[k]=='L')
                    {
                        lastEndPlace = k;
                        placeOfNextL = k;
                        break;
                    }
                }
                if(placeOfNextL==0)
                {
                    for(int a = i+1;a<charArray.length;a++)
                    {
                        charArray[a] = 'R';
                    }
                    i = charArray.length;
                }
                else {
                    int midplace = (i+placeOfNextL)/2;
                    if((i+placeOfNextL)%2==0)
                    {
                        for(int a = i+1; a < midplace ; a++)
                            charArray[a] = 'R';
                        for(int a = midplace+1 ; a < placeOfNextL ; a++)
                            charArray[a] = 'L';
                    }
                    else
                    {
                        for(int a = i+1 ; !(a>midplace) ; a++)
                            charArray[a] = 'R';
                        for(int a = midplace+1 ; a < placeOfNextL ; a++)
                            charArray[a] = 'L';
                    }
                    i = placeOfNextL;
                }

            }
        }
        dominoes = new String(charArray);
        return dominoes;
    }

}
