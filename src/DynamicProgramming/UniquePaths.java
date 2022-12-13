package DynamicProgramming;

import java.util.Arrays;

    /*
    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
    The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or
    right at any point in time. Given the two integers m and n, return the number of possible unique paths that the
    robot can take to reach the bottom-right corner.
    */

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m+1][n+1];
        Arrays.fill(dp[0], 1);
        for (int k =0 ; k < m ; k++) {
            dp[k][0] = 1;
        }

        for (int i = 1 ; i < m; i ++) {
            for (int j = 1 ; j < n; j++) {
                System.out.println(i + " , " + j);
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                System.out.println(dp[i][j]);
            }
        }
        return dp[m-1][n-1];

    }



    // Declare 1D array of size n. Break the problem into subproblem, for example, if m is 5, n is 4,
    // first find the solution for 1 * n and store it in a declared 1D array. 
    // Then use the same space to calculate 2 * n ,3 * n , . . . . , m * n using the same 1D array.
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        if(n == 1 || m == 1) return 1;
        for(int i = 0; i < dp.length; i++) dp[i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];
    }

}
