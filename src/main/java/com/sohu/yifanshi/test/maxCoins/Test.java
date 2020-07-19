package com.sohu.yifanshi.test.maxCoins;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{7,9,8,0,7,1,3,5,5,2,3};
        long startTime = System.currentTimeMillis();
        System.out.println(Solution.maxCoins(nums));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        Solution solution = new Solution();
        System.out.println(solution.maxCoin(new int[]{3,1,5,8}));
    }
}
