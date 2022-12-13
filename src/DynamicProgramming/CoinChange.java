package DynamicProgramming;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing
a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount of money
cannot be made up by any combination of the coins, return -1. You may assume that you have an infinite number of each
kind of coin.
*/

public class CoinChange {
    public static void main(String[] args) {

    }

    public static int coinChange(int[] coins, int amount) {

        // The maximum number of coins for any amount is amount, given that a 1$ coin. Hence setting max as amount+1
        // as upper bound
        int max = amount + 1;

        // From 0 --> amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        // number of coins to make 0$ is 0.
        dp[0] = 0;

        // Loop to find the coins from 1$ --> amount$
        for (int i = 1; i < amount +1; i++) {
            for (int j = 0; j < coins.length; j++) {
                // The value of a single coin is > amount ? discard that coin : we are taking that coin to add to the amount.
                // Back track and find the minimum coins for i-coins[j], which is dp[i-coins[j]]
                // As we are taking the coin in to consideration add 1. dp[i-coins[j]] +1
                // That need not to be a minimum value. Hence compare that with the previous value of dp[i]
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
