package com.sohu.yifanshi.test.Multiply;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123456789","987654321"));
    }
    public String multiply(String num1, String num2) {
        String longstr,shortstr;
        if(num1.length()>num2.length())
        {
            longstr = num1;
            shortstr = num2;
        }else
        {
            longstr = num2;
            shortstr = num1;
        }
        int index=0;
        String result = "0";
        HashMap<Integer,String> resultMap = new HashMap<>();
        resultMap.put(0,"0");
        resultMap.put(1,shortstr);
        for(int i = longstr.length()-1;i>=0;i--,index++)
        {
            String tempresult = calculateShortStr(resultMap,longstr.charAt(i)-48);
            for(int j = 0; j < index;j++)
            {
                tempresult+="0";
            }
            result = strplus(tempresult,result);
        }
        boolean flag = false;
        for(int i = 0 ; i < result.length() ; i++)
        {
            if(result.charAt(i)!='0')
            {
                flag = true;
                break;
            }

        }
        return flag?result:"0";
    }
    public String calculateShortStr (Map<Integer,String> resultMap,Integer multi)
    {
        if(!resultMap.keySet().contains(multi))
        {
            String result = strplus(calculateShortStr(resultMap,multi-1),resultMap.get(1));
            resultMap.put(multi,result);
            return result;
        }else
            return resultMap.get(multi);
    }
    public String strplus(String str1,String str2)
    {
        StringBuilder str = new StringBuilder();
        int jinwei = 0;
        int i=str1.length()-1,j=str2.length()-1;
        for(;i>=0&&j>=0;i--,j--)
        {
            int x = str1.charAt(i)+str2.charAt(j)+jinwei;
            jinwei = 0;
            if(x>=106)
            {
                jinwei = 1;
                str.append(switchChar(x-10));
            }else{
                str.append(switchChar(x));
            }
        }
        if(i>=0)
        {
            while (i>=0)
            {
               int x = str1.charAt(i)+'0'+jinwei;
               jinwei = 0;
               if(x>=106)
               {
                   jinwei = 1;
                   str.append(switchChar(x-10));
               }else {
                   str.append(switchChar(x));
               }
               i--;
            }
        }else {
            while (j>=0)
            {
                int x = str2.charAt(j)+'0'+jinwei;
                jinwei = 0;
                if(x>=106)
                {
                    jinwei = 1;
                    str.append(switchChar(x-10));
                }else {
                    str.append(switchChar(x));
                }
                j--;
            }
        }
        if(jinwei!=0)
            str.append("1");
        return str.reverse().toString();
    }
    public char switchChar(int i)
    {
        switch (i-96)
        {
            case 0:return '0';
            case 1:return '1';
            case 2:return '2';
            case 3:return '3';
            case 4:return '4';
            case 5:return '5';
            case 6:return '6';
            case 7:return '7';
            case 8:return '8';
            case 9:return '9';
            default:return '0';
        }
    }


}
