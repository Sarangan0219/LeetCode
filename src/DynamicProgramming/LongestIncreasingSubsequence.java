package DynamicProgramming;

import java.util.Arrays;

//Given an integer array arr, return the length of the longest strictly increasing subsequence.

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int [] dp = new int [n];

        // Initiate the dp array with 1s.
        Arrays.fill(dp, 1);

        for (int i =0; i < n ;i ++) {
            // For subsequence from i --> j
            for (int j = 0; j< i; j ++) {
                // To check if the selected subsequence is strictly increasing
                if (arr[i] > arr[j]) {
                    // Get the maximum of length (current subsequence, previous maximum subsequence)
                    dp[i] = Math.max (dp[j] + 1, dp [i]);

                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
