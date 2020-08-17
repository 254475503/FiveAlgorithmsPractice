package com.sohu.yifanshi.test.addString;

public class Solution {
    public static void main(String[] args) {
        boolean[] dfs = new boolean[1];
        System.out.println(dfs[0]);
    }

    public String addStrings(String num1, String num2) {
        int jinwei = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder result = new StringBuilder();

        for (; i >= 0 && j >= 0; i--, j--) {
            int temp = num1.charAt(i) + num2.charAt(j) - 96 + jinwei;
            if (temp < 10)
                jinwei = 0;
            else
                jinwei = 1;
            result.append(""+temp%10);
        }
        if(i>j)
        {
            while (i>=0)
            {
                int temp = num1.charAt(i)+jinwei-48;
                if (temp < 10)
                    jinwei = 0;
                else
                    jinwei = 1;
                result.append(""+temp%10);
                i--;
            }
        }else{
            while (j>=0)
            {
                int temp = num2.charAt(j)+jinwei-48;
                if (temp < 10)
                    jinwei = 0;
                else
                    jinwei = 1;
                result.append(""+temp%10);
                j--;
            }
        }
        if(jinwei==1)
            result.append("1");
        return result.reverse().toString();
    }

    public int getNum(int temp) {
        return temp - 96;
    }
}
