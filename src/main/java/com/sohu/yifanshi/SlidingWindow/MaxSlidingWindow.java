package com.sohu.yifanshi.SlidingWindow;

import javax.print.attribute.IntegerSyntax;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSlidingWindow {
    private ArrayDeque<Integer> deque = new ArrayDeque<>();
    private int[] nums;
    /*public static void main(String[] args) throws IOException {
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
        System.out.println(nums.length);
        long startTime = System.currentTimeMillis();
        int[] result = maxSlidingWindow.maxSlidingWindow(nums,50000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }

    /*----------------------------------------*/

    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();

    public void clean_deque(int i, int k) {
        while (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
            deq.removeLast();
        }
    }


    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow(new int[]{7, 2, 4}, 2);
    }

    /*手写练习*/
/*    public void fixTheDeque(int i, int k) {
        while (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1)
            return new int[0];
        if (k == 1)
            return nums;
        this.nums = nums;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            fixTheDeque(i, k);
            deque.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return result;
    }*/
        public int[] maxSlidingWindow ( int[] nums, int k){
            if (k == 1)
                return nums;
            this.nums = nums;
            int[] result = new int[nums.length - k + 1];
            for (int i = 0; i < k - 1; i++) {
                clean_deque(i, k);
                deq.addLast(i);
            }
            if (nums.length < k)
                return new int[]{deq.getFirst()};
            for (int i = k - 1; i < nums.length; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                result[i - k + 1] = nums[deq.getFirst()];
            }
            return result;
        }


        /*------------------------------------------*/
        private int[][] dp;
    /*public int[] maxSlidingWindow(int[] nums, int k) {
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
   /*public int[] maxSlidingWindow(int[] nums,int k)
   {

        return recursive(Arrays.stream(nums).boxed().collect(Collectors.toList()),1,k).stream().mapToInt(Integer::valueOf).toArray();
   }*/
        public List<Integer> recursive (List < Integer > nums,int k, int target)
        {
            if (k == target)
                return nums;
            List<Integer> nextList = new ArrayList<>(nums.size() >> 2 + 1);
            for (int i = 0, j = 0; i < nums.size() - 1; i++, j++) {
                nextList.add(j, Math.max(nums.get(i), nums.get(i + 1)));
            }
            nums = null;
            return recursive(nextList, k + 1, target);
        }

        public List<Integer> recursiveChangeToLoop (List < Integer > nums,int k, int target)
        {
            for (int i = k; i < target; i++) {
                List<Integer> nextList = new ArrayList<>(nums.size() >> 2 + 1);
                for (int l = 0, j = 0; l < nums.size() - 1; l++, j++) {
                    nextList.add(j, Math.max(nums.get(l), nums.get(l + 1)));
                }
                nums = nextList;
            }
            return nums;
        }
        private int dpfunction ( int i, int j){
            int result = 0;
            if (i == j)
                return dp[i][i];
            else if (j - i == 1) {
                result = Math.max(dp[i][i], dp[j][j]);
            } else {
                result = Math.max(dpfunction(i, j - 1), dp[j][j]);
            }
            if (dp[i][j] == 0)
                dp[i][j] = result;
            return result;
        }

}
