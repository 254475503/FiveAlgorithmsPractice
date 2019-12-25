package com.sohu.yifanshi.test.minimunTotal;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size()-1 ; i > 0 ; i --)
        {
            List<Integer> list = triangle.get(i);
            List<Integer> listup = triangle.get(i-1);
            for(int j = 0 ; j < list.size()-1 ; j ++ )
            {
                if(list.get(j)<list.get(j+1))
                    listup.set(j,listup.get(j)+list.get(j));
                else
                    listup.set(j,listup.get(j)+list.get(j+1));
            }
        }
        return triangle.get(0).get(0);
    }
}
