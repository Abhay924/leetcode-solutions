class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        Integer[][] dp = new Integer[n][n + 1];
        return dfs(0, 1, suffix, dp, n);
    }
    private int dfs(int i, int m, int[] suffix, Integer[][] dp, int n) {
        if (i >= n) return 0;
        if (2 * m >= n - i) return suffix[i];
        if (dp[i][m] != null) return dp[i][m];
        int best = 0;
        for (int x = 1; x <= 2 * m; x++) {
            best = Math.max(best, suffix[i] - dfs(i + x, Math.max(m, x), suffix, dp, n));
        }
        return dp[i][m] = best;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna