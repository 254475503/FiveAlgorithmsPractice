package com.sohu.yifanshi.SlidingWindow;

import javax.print.attribute.IntegerSyntax;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSlidingWindow {
    public static void main(String[] args) throws IOException {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        System.out.println(System.currentTimeMillis());
        File file = new File("C:\\Users\\shiyf286\\Desktop\\test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int length = 0;
        StringBuffer sb = new StringBuffer();
        while ((length = fileInputStream.read(buffer))!=-1)
        {
            sb.append(new String(buffer,0,length));
        }

        System.out.println(sb);
    }
    private int[][] dp ;
   /* public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        dp = new int[nums.length][nums.length];
        for(int i = 0 ; i < nums.length; i ++)
        {
            dp[i][i] = nums[i];
        }
        for(int i = 0 ; i <nums.length-k+1;i++)
        {
            result[i] = dpfunction(i,i+k-1);
        }
        return result;
    }*/
   public int[] maxSlidingWindow(int[] nums,int k)
   {

        return recursive(Arrays.stream(nums).boxed().collect(Collectors.toList()),1,k).stream().mapToInt(Integer::valueOf).toArray();
   }
    public List<Integer> recursive(List<Integer> nums,int k,int target)
    {
        if(k==target)
            return nums;
        List<Integer> nextList = new ArrayList<>(nums.size()>>2+1);
        for(int i = 0,j = 0 ; i < nums.size()-1 ; i++,j++)
        {
            nextList.add(j,Math.max(nums.get(i),nums.get(i+1)));
        }
        nums = null;
        return recursive(nextList,k+1,target);
    }
    private int dpfunction(int i, int j) {
        int result = 0;
        if(i==j)
            return dp[i][i];
        else if(j-i==1)
        {
            result = Math.max(dp[i][i],dp[j][j]);
        }
        else {
            result = Math.max(dpfunction(i,j-1),dp[j][j]);
        }
        if(dp[i][j]==0)
            dp[i][j] = result;
        return result;
    }
}
