package com.sohu.yifanshi.ReviewPractice;

import java.util.HashSet;

public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder spiralOrder= new SpiralOrder();
        int[][] array = {{0}};
        spiralOrder.spiralOrder(array);
    }
    public HashSet didSet = new HashSet();
    public int size = 0;
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int[] result = new int[matrix.length*matrix[0].length];
        printNum(0,matrix,result);
        return result;
    }
    public void printNum(int count,int[][] matrix,int[] resultmatrix)
    {
        int rowEnd = matrix.length-count-1;
        int columnEnd = matrix[0].length-count-1;
        if(count!=0)
        {
            if(didSet.contains(count)||rowEnd==0||columnEnd==0||size==resultmatrix.length)
                return;
        }
        for(int i = count;i<=columnEnd;i++)
        {
            resultmatrix[size] = matrix[count][i];
            size++;
            if(count==i)
                this.didSet.add(i);
        }
        for(int i = count+1;i<=rowEnd;i++)
        {
            resultmatrix[size] = matrix[i][columnEnd];
            size++;
            if(i==columnEnd)
                this.didSet.add(i);
        }
        if(count!=rowEnd)
        {
            for(int i = columnEnd-1;i>=count;i--)
            {
                resultmatrix[size] = matrix[rowEnd][i];
                size++;
                if(i==rowEnd)
                    this.didSet.add(i);
            }
        }
        if(count!=columnEnd)
        {
            for(int i = rowEnd-1;i>count;i--)
            {
                resultmatrix[size] = matrix[i][count];
                size++;
                if(i==count)
                    this.didSet.add(i);
            }
        }

        printNum(count+1,matrix,resultmatrix);
    }

}
