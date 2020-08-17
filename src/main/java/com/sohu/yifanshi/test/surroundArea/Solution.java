package com.sohu.yifanshi.test.surroundArea;

public class Solution {
    public static void main(String[] args) {
        char[][] test = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        Solution solution = new Solution();
        solution.solve(test);
        System.out.println(1);
    }
    public void solve(char[][] board) {
        if(board.length == 0||board[0].length==0)
            return;
        int[][] dfs = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(board[i][j]=='X')
                    dfs[i][j] = 1;
                else
                    dfsrecur(dfs,i,j,board);
            }
        }

        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(dfs[i][j]==1&&board[i][j]=='O')
                    board[i][j] = 'X';
            }
        }
    }

    public boolean dfsrecur(int[][] dfs,int i,int j,char[][] board)
    {
        if(i<0||j<0||i>=board.length||j>=board[0].length)
            return false;
        if(dfs[i][j]==-1||dfs[i][j]==1)
            return true;
        if(dfs[i][j]==2)
            return false;
        if(board[i][j]=='X')
        {
            dfs[i][j] = 1;
            return true;
        }
        else
        {
            dfs[i][j] = -1;
            boolean answer =  dfsrecur(dfs,i-1,j,board)&&dfsrecur(dfs,i+1,j,board)&&dfsrecur(dfs,i,j-1,board)&&dfsrecur(dfs,i,j+1,board);
            dfs[i][j] = answer?1:2;
            return answer;
        }
    }
}
