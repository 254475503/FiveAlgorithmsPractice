package com.sohu.yifanshi.ReviewPractice;
/*请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class roadInMatrix {
    public static void main(String[] args) {
        roadInMatrix roadInMatrix = new roadInMatrix();
        char[][] chars = new char[][] {{'a'},{'a'}};
        System.out.println(roadInMatrix.exist(chars,"aaa"));
    }
    private String word ;
    private Integer indexOfWord = 0;
    private Integer maxMatch = 0;
    public boolean exist(char[][] board, String word) {

        this.word = word;
        for(int i = 0 ; i < board.length;i++)
        {
            for(int j = 0 ; j < board[i].length ; j++)
            {
                if(maxMatch==word.length())
                    break;
                if(board[i][j]==word.charAt(indexOfWord))
                {

                    findword(board,i,j,i,j);
                    if(maxMatch==word.length())
                        break;
                    indexOfWord = 0;
                }

            }
        }
        if(maxMatch!=word.length())
            return false;
        else
            return true;
    }
    public void findword(char[][] board,int i ,int j,int lasti,int lastj )
    {
        if(maxMatch==word.length())
            return;
        if(board[i][j]==word.charAt(indexOfWord))
        {
            this.indexOfWord++;
            if(indexOfWord>maxMatch)
                maxMatch = indexOfWord;
            if(maxMatch==word.length())
                return;
        }
        else
            return;
        char tmp = board[i][j];
        board[i][j] = '/';
        if(i!=0)
        {
            findword(board,i-1,j,i,j);
        }
        if(i!=board.length-1)
        {
            findword(board,i+1,j,i,j);
        }
        if(j!=0)
        {
            findword(board,i,j-1,i,j);
        }
        if(j!=board[i].length-1)
        {
            findword(board,i,j+1,i,j);
        }
        indexOfWord--;
        board[i][j] = tmp;
        return;
    }

}
