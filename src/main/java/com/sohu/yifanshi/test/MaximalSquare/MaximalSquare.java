package com.sohu.yifanshi.test.MaximalSquare;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix){
        //矩阵中最大的全为1的正方形面积。动态规划算法。
        //首先设置一个和原矩阵同样大小的矩阵作为ret，我们观察发现，面积为2的正方形，从他的右下角的1为中心观察，
        //他的左边，左上，正上方都要是1。我们则把这个中心在ret中标为2。那么面积为3的正方形右下角为中心观察，
        //他的左边，左上，正上方都要是2。这样我们的递推式就来了。ret[i][j] = math.min(ret[i-1][j],ret[i-1][j-1],ret[i][j-1])+1
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0 ; i < matrix.length ; i ++)

        {
            resultMatrix[i][0] = matrix[i][0]-48;//此处-48只是为了让char转过来的0为0而已
            max = resultMatrix[i][0]>max?resultMatrix[i][0]:max;
        }

        for(int i = 0 ; i < matrix[0].length ; i ++)
        {
            resultMatrix[0][i] = matrix[0][i]-48;
            max = resultMatrix[0][i]>max?resultMatrix[0][i]:max;
        }

        for(int i = 1 ; i <matrix.length ; i ++)
        {
            for(int j = 1 ; j < matrix[0].length ; j ++)
            {
                if(matrix[i][j]=='0')
                    resultMatrix[i][j] = 0;
                else {
                    int left = resultMatrix[i][j - 1];
                    int left_top = resultMatrix[i - 1][j - 1];
                    int top = resultMatrix[i - 1][j];
                    resultMatrix[i][j] = Math.min(left, Math.min(left_top, top)) + 1;
                    if (resultMatrix[i][j] > max)
                    {
                        max = resultMatrix[i][j];
                    }
                }
            }
        }
        System.out.println(max);
        return max*max;

    }
}
