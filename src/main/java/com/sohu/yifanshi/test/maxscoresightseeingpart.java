package com.sohu.yifanshi.test;

public class maxscoresightseeingpart {
    /**
     * leetcode1014题，
     * A[I]+A[J]+I-J可以移项成A[I]+I+A[J]-J这样就可以分别通过线性的时间去求A[I]+[I]与A[J]-J同时满足I<J的最大值来求出结果了。
     *
     * */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);//a[j]-j+上一轮循环算出的最大a[i]+i的最大值记录
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);//a[i]+i最大值
        }
        return ans;
    }

}
