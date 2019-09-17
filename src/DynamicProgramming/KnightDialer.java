package DynamicProgramming;
/*
*
*
*/


public class KnightDialer {
    public int knightDialer(int N) {
        int[][] dirs = new int[][]{{4, 6}, {6, 8}, {7, 9}, {3, 9, 0}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[N + 1][10];

        for (int j = 0; j < dp[0].length; j++)
            dp[1][j] = 1;
        int mod = 1000000007;
        for (int i = 2; i < dp[0].length; i++)
            for (int j = 0; j < dp[0].length; j++) {
                int[] dir = dirs[j];
                for (int num : dir) {
                    dp[i][j] = dp[i][j] + dp[i - 1][num];
                    dp[i][j] = dp[i][j] % mod;
                }
            }
        int count = 0;
        for (int i = 0; i < dp[0].length; i++) {
            count = count + dp[N][i];
            count = count % mod;
        }
        return count;
    }
}