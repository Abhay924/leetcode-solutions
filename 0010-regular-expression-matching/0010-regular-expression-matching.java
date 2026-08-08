class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);
                
                if (currentP == currentS || currentP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentP == '*') {
                    dp[i][j] = dp[i][j - 2];
                    char precedingP = p.charAt(j - 2);
                    if (precedingP == currentS || precedingP == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna