package com.sohu.yifanshi.test.LRtransform;

import java.util.ArrayList;
import java.util.List;

public class canTransform {//no.777 在LR字符串中交换相邻字符
    /*
    * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换
      一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
        示例 :

        输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
        输出: True
        解释:
        我们可以通过以下几步将start转换成end:
        RXXLRXRXL ->
        XRXLRXRXL ->
        XRLXRXRXL ->
        XRLXXRRXL ->
        XRLXXRRLX
        这道题重在分析与总结规律。
        首先只能从XL变为LX, RX变为XR。这个变化过程是不可逆的这点需要记住。那这样就带来一个规律。变化以后的L他在这个数组中的下标会变小，而R会变大。
        第二个规律就是，LR不能互换的话，我们将X全部去掉，起始字符串与结果字符串应该是相等的。就这两个规律，就能将这题做出来了。
        */
    public static void main(String[] args) {
        String s1 = "XXXXRXXXLX";
        String s2 = "XXXXRLXXXX";
        System.out.println(canTransform(s1,s2));
    }

    public static boolean canTransform(String start, String end) {
        if (start.equals(end))
            return true;
        char[] starter = start.toCharArray();
        char[] ender = end.toCharArray();
        List<Character> startCList = new ArrayList<Character>();
        List<Character> endCList = new ArrayList<Character>();
        List<Integer> startIList = new ArrayList<Integer>();
        List<Integer> endIList = new ArrayList<Integer>();

        for (int i = 0; i < start.length(); i++) {
            if (starter[i] != 'X') {
                startCList.add(starter[i]);
                startIList.add(i);
            }
            if (ender[i] != 'X') {
                endCList.add(ender[i]);
                endIList.add(i);
            }
        }

        if (!startCList.equals(endCList)) {
            return false;
        }

        for (int i = 0; i < startCList.size(); i++) {
            if (startCList.get(i) == 'L')
            {
                if (startIList.get(i) < endIList.get(i))
                    return false;
            }
            else
            {
                if(startIList.get(i) > endIList.get(i))
                    return false;
            }


        }
        return  true;
    }

}
