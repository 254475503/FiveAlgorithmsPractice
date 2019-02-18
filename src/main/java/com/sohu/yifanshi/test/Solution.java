package com.sohu.yifanshi.test;


import java.util.Scanner;

public class Solution {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (line != null) {
            int[] nums = stringToIntegerArray(line);

            int target = Integer.parseInt(line);

            int[] ret = new Solution().twoSum(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length ; i++)
        {
            for(int j = 0 ; j < nums.length ; j++)
            {
                if(j==i)
                    continue;
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }

        }
        return new int[]{};
    }
}
