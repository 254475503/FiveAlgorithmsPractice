package com.sohu.yifanshi.test.SowrdTowardOffer.Test2;

/**
 * 一个二维数组，从左往右是递增的，从上往下是递增的，现在给你一个数，让你再这个二维数组中找出来。
 * 这道题乍一看从有点难度。从0，0开始 如果这个数比目标数小了，那到底是向下呢还是想左呢？难以抉择的原因
 * 是因为向下与向左都是增加。只有增加就很难抉择。那么我们可以选择从右上角或者左下角作为起点开始比。
 * */
public class Test {
    public static void main(String[] args) {

    }
    public static boolean find(int[][] matrix, int number){
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int column = matrix.length-1;
        int list = 0;
        while (column>0&&list<matrix[0].length)
        {
            if(matrix[column][list]==number)
                return true;
            else if(matrix[column][list]>number)
                column--;
            else if (matrix[column][list]<number)
                list++;
        }
        return false;
    }
}
