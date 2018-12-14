package com.sohu.yifanshi.test.dividePipeQuestion;

public class Test {
    public static void main(String[] args) {
        int[] bestPricePipe = new int[19];
        System.out.println(System.currentTimeMillis());
        System.out.println( DividePipeQuestion.dividePipe(17));
        System.out.println(System.currentTimeMillis());
        System.out.println(DividePipeQuestion.dividePipe(bestPricePipe,17));
        System.out.println(System.currentTimeMillis());
        System.out.println(DividePipeQuestion.dividePipeFromLow(17));
        System.out.println(System.currentTimeMillis());
    }
}
