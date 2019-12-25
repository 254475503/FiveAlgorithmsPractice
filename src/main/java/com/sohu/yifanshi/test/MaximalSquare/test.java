package com.sohu.yifanshi.test.MaximalSquare;

import org.junit.Test;

public class test {
    @Test
    public void test()
    {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalSquare.maximalSquare(matrix);
    }

}
