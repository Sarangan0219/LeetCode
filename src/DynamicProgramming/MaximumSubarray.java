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
}
