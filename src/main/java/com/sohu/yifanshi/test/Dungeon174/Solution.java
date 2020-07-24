package com.sohu.yifanshi.test.Dungeon174;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import javax.sound.midi.Soundbank;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.calculateMinimumHP(new int[][]{{0,-3}});
    }
   /* public int calculateMinimumHP(int[][] dungeon) {
        DpNode[][] dp = createMatrix(dungeon.length,dungeon[0].length);
        dp[0][0].health = dungeon[0][0];
        dp[0][0].minhealth = dungeon[0][0]>=0?0:dungeon[0][0];
        for(int i = 1 ; i < dungeon.length ; i ++)
        {
            dp[i][0].health = dungeon[i][0] +dp[i-1][0].health;
            dp[i][0].minhealth = dp[i][0].health<dp[i-1][0].minhealth?dp[i][0].health:dp[i-1][0].minhealth;
        }
        for(int i = 1 ; i < dungeon[0].length ; i ++)
        {
            dp[0][i].health = dungeon[0][i]+dp[0][i-1].health;
            dp[0][i].minhealth = dp[0][i].health<dp[0][i-1].minhealth?dp[0][i].health:dp[0][i-1].minhealth;
        }
        for(int i = 1; i < dungeon.length ; i ++)
        {
            for(int j = 1 ; j < dungeon[0].length ; j++)
            {
                int tempMinhealthTop = dungeon[i][j]+dp[i][j-1].health<dp[i][j-1].minhealth?dungeon[i][j]+dp[i][j-1].health:dp[i][j-1].minhealth;
                int tempMinhealthLeft = dungeon[i][j]+dp[i-1][j].health<dp[i-1][j].minhealth?dungeon[i][j]+dp[i-1][j].health:dp[i-1][j].minhealth;
                if(tempMinhealthLeft>tempMinhealthTop)
                {
                    dp[i][j].health = dp[i-1][j].health + dungeon[i][j];
                    dp[i][j].minhealth = tempMinhealthLeft;
                }else if(tempMinhealthLeft<tempMinhealthTop)
                {
                    dp[i][j].health = dp[i][j-1].health + dungeon[i][j];
                    dp[i][j].minhealth = tempMinhealthTop;
                }else{
                    dp[i][j].health = Math.max(dp[i-1][j].health,dp[i][j-1].health)+dungeon[i][j];
                    dp[i][j].minhealth = tempMinhealthLeft;
                }
            }
        }
        return 0-dp[dungeon.length-1][dungeon[0].length-1].minhealth+1;
    }
    public  DpNode[][] createMatrix(int i,int j)
    {
        DpNode[][] matrix = new DpNode[i][j];
        for(int a = 0 ; a < i ; a++)
        {
            for(int b = 0 ; b < j ;b++)
            {
                matrix[a][b] = new DpNode();
            }
        }
        return matrix;
    }
    class DpNode{
        public int health;
        public int minhealth;

    }*/
   public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dungeon.length-1][dungeon[0].length-1] = dungeon[dungeon.length-1][dungeon[0].length-1]>=0?0:dungeon[dungeon.length-1][dungeon[0].length-1];
        for(int i = dungeon.length-2; i>=0;i--)
        {
            int temp = dungeon[i][dungeon[0].length-1]+dp[i+1][dungeon[0].length-1];
            dp[i][dungeon[0].length-1] = temp>=0?0:temp;
        }
        for(int i = dungeon[0].length-2 ; i>=0;i--)
        {
            int temp = dungeon[dungeon.length-1][i]+dp[dungeon.length-1][i+1];
            dp[dungeon.length-1][i] = temp>=0?0:temp;
        }
        for(int i = dungeon.length)
   }
}
