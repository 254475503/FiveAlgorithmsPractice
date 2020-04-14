package com.sohu.yifanshi.test.MatrixFindNums;

public class Solution {//剑指offer，二维数组中的查找。
    public  static  boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int j = matrix.length - 1 ; j >-1 ; j--)
        {
            for(int i = 0 ; i < matrix[j].length ; i++)
            {
                if(target==matrix[j][i])
                    return true;
                else if(target<matrix[j][i])
                    break;
                else if(target>matrix[j][i])
                    continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        findNumberIn2DArray(matrix,20);
    }
}
