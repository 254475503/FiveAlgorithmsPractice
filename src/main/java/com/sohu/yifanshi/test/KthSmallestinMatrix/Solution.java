package com.sohu.yifanshi.test.KthSmallestinMatrix;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,2},{1,3}};
        Solution solution = new Solution();
        solution.kthSmallest(ints,1);
    }
    public int kthSmallest(int[][] matrix, int k) {
        int small = matrix[0][0];
        int big = matrix[matrix.length-1][matrix[0].length-1];
        return halfSearch(matrix,small,big,k);

    }

    private int halfSearch(int[][] matrix, int small, int big, int k) {
        long middle = ((long)small+(long)big)>>1;
        int count = 0;
        int multi = 0;
        for(int i = matrix.length-1,j=0;i>=0&&j<matrix[0].length; )
        {
            while (i>=0&&matrix[i][j]>=middle)
            {
                if(matrix[i][j]==middle) {
                    int temp = i;
                    while (temp >= 0 && matrix[temp][j] == middle) {
                        multi++;
                        temp--;
                    }
                    break;
                }
                i--;
            }
            count+=(i+1);
            j++;
        }
        if(k<=(count)&&k>=(count-(multi-1)))
            return (int) middle;
        else
            return count<k?halfSearch(matrix,(int)middle+1,big,k):halfSearch(matrix,small,(int)middle,k);
    }
}
