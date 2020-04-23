package com.sohu.yifanshi.ReviewPractice;

public class RobotMovingRange {
    private int[][] arrived;
    private int count = 0;
    public int movingCount(int m, int n, int k) {
        arrived = new int[m][n];
        if(m==0||n==0||k<0)
            return count;
        moving(0,0,m,n,k);
        return count;
    }

    public void moving(int row,int column,int m,int n,int k)
    {
        if(row<0||row>m-1||column<0||column>n-1||arrived[row][column]==1)
            return;
        if(getNumbersSum(row)+getNumbersSum(column)<=k)
        {
            count++;
            arrived[row][column] = 1;
            moving(row+1,column,m,n,k);
            moving(row,column+1,m,n,k);
            moving(row-1,column,m,n,k);
            moving(row,column-1,m,n,k);
        }

    }
    public int getNumbersSum(int i)
    {
        if(i==0)
            return 0;
        int j = i%10;
        return j+getNumbersSum(i/10);
    }
}
