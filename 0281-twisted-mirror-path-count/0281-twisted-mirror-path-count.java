class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1000000007;
        int[][][] resolve = new int[m + 1][n + 1][2];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                resolve[i][j][0] = -1;
                resolve[i][j][1] = -1;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    resolve[i][j][0] = i * n + j;
                    resolve[i][j][1] = i * n + j;
                } else {
                    if (i + 1 < m) {
                        resolve[i][j][0] = resolve[i + 1][j][1];
                    }
                    if (j + 1 < n) {
                        resolve[i][j][1] = resolve[i][j + 1][0];
                    }
                }
            }
        }

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1 || (i == m - 1 && j == n - 1)) {
                    continue;
                }
                if (j + 1 < n) {
                    int dest = resolve[i][j + 1][0];
                    if (dest != -1) {
                        int r = dest / n;
                        int c = dest % n;
                        dp[i][j] = (dp[i][j] + dp[r][c]) % MOD;
                    }
                }

                if (i + 1 < m) {
                    int dest = resolve[i + 1][j][1];
                    if (dest != -1) {
                        int r = dest / n;
                        int c = dest % n;
                        dp[i][j] = (dp[i][j] + dp[r][c]) % MOD;
                    }
                }
            }
        }
        return dp[0][0];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna