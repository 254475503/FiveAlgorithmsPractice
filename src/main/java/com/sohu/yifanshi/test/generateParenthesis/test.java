package com.sohu.yifanshi.test.generateParenthesis;

import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> stringList = GenerateParentHesis.generateParenthesis(1);
        for(String str : stringList)
            System.out.println(str);
    }
}
