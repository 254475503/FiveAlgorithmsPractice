package com.sohu.yifanshi.ReviewPractice;

public class MaxGiftValue {
    public static void main(String[] args) {
        MaxGiftValue maxGiftValue = new MaxGiftValue();
        maxGiftValue.maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
    public int maxValue(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int[][] dp  = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        recur(dp.length-1,dp[0].length-1,dp,grid);
        return dp[dp.length-1][dp[0].length-1];
        /*标准答案，比我判断少多了。虽然我思路是一样的 但是同数据规模中我的方法判断次数太多了  耗时太多。 他这种是自底向顶的dp，我的是自定向底的dp
        * int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];

作者：jyd
链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        * */
    }
    public int recur(int i , int j , int[][] dp,int[][] grid)
    {
        int num = 0;
        if(i==0&&j==0)
        {
            return dp[0][0];
        }
        else if(i==0&&j!=0)
        {
            num = dp[i][j-1]==0?recur(i,j-1,dp,grid):dp[i][j-1];

        }
        else if(i!=0&&j==0)
        {
            num = dp[i-1][j]==0?recur(i-1,j,dp,grid):dp[i-1][j];
        }else {
            num  = Math.max(recur(i,j-1,dp,grid),recur(i-1,j,dp,grid));
        }

        num+=grid[i][j];
        dp[i][j] = num;
        return num;
    }

}
