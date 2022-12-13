package DynamicProgramming;

/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.
Input: s = "babgbag", t = "bag"
*/

public class DistinctSubsequences {

    public static void main(String[] args) {
        numDistinct("babgbag", "bag");
    }

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];

        // Empty String is present in any String
        for (int k =0 ; k < m+1 ; k++) {
            dp[k][0] = 1;
        }


        for (int i = 1; i < m +1; i ++) {
            for (int j= 1; j < n+1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    /*
                     *  We have 2 choices to proceed
                     * 1. Case 1 : As 2 characters are matching take that character to be included in the subsequence
                     * ("babgbag" -- > "abgbag" --> i-1  & "bag" -- > "ag" -- > j-1)
                     * 2. Case 2  : Not taking that character
                     * ("babgbag" -- > "abgbag" -- > i-1  & "bag" -- > "bag" -- > j)
                    * */
                    dp[i][j] = dp[i-1][j-1] + dp [i-1][j];
                } else {
                    // Characters are not matching. Thus case 2.
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }

}
