package DynamicProgramming;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
return 0.
*/
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        // Edge case: if the prices array is empty or has only one element, we can't make any profit
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize variables to keep track of the maximum sum and the current sum
        int maxSum = 0;
        int currentSum = 0;

        // Iterate through the prices array
        for (int i = 1; i < prices.length; i++) {
            // Calculate the difference between the current price and the previous price
            int difference = prices[i] - prices[i-1];

            // Update the current sum by adding the difference
            currentSum = Math.max(currentSum + difference, 0);

            // Update the maximum sum, if necessary
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

/*

Solution Explanation

   - This code uses Kadane's algorithm to find the maximum subarray sum in the prices array.
   - It calculates the difference between each pair of consecutive elements and updates the maximum sum, if necessary.
     At the end, it returns the maximum sum, which represents the maximum profit that can be achieved from buying and
     selling a stock.
    - This code has a space complexity of O(1), as it only uses a constant number of variables regardless of the size of
    the input.
    - The time complexity is  O(n), where n is the number of elements in the `prices` array.
*/

}
