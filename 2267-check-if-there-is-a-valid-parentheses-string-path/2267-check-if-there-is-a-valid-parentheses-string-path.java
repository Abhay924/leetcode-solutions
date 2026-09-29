class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        if (grid[0][0] == ')') {
            return false;
        }
        int maxBalance = m + n;
        boolean[][][] dp = new boolean[m][n][maxBalance];
        dp[0][0][1] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int value = grid[i][j] == '(' ? 1 : -1;
                for (int balance = 0; balance < maxBalance; balance++) {
                    int previousBalance = balance - value;
                    if (previousBalance < 0 ||
                        previousBalance >= maxBalance) {
                        continue;
                    }
                    if (i > 0 && dp[i - 1][j][previousBalance]) {
                        dp[i][j][balance] = true;
                    }
                    if (j > 0 && dp[i][j - 1][previousBalance]) {
                        dp[i][j][balance] = true;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna