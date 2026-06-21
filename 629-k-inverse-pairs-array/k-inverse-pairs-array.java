class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            long prefix = 0;

            for (int j = 0; j <= k; j++) {
                prefix += dp[i - 1][j];

                if (j >= i) {
                    prefix -= dp[i - 1][j - i];
                }

                prefix = (prefix % MOD + MOD) % MOD;
                dp[i][j] = (int) prefix;
            }
        }
        return dp[n][k];
    }
}