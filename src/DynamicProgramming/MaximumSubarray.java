package DynamicProgramming;

/*
Given an integer array nums, find the subarray which has the largest sum and return its sum.
*/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int [] dp = new int [nums.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[0] = nums[0];
            } else {
                dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static int maxSum(int[] nums) {
        // Edge case: if the nums array is empty, the maximum sum is 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize variables to keep track of the maximum sum and the current sum
        int maxSum = nums[0];
        int currentSum = nums[0];

        // Iterate through the nums array, starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update the current sum by adding the ith element
            currentSum = Math.max(currentSum + nums[i], nums[i]);

            // Update the maximum sum, if necessary
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

/*

    This code uses Kadane's algorithm to find the maximum subarray sum in the nums array. It updates the current sum
    and the maximum sum on each iteration, and at the end it returns the maximum sum.
    This solution has a space complexity of O(1) and a time complexity of O(n), where n is the number of elements in
    the nums array, so it should be efficient for large inputs.

    */
}
