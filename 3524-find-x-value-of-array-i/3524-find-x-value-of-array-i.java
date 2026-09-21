class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] cur = new long[k];
            int x = num % k;
            cur[x]++;
            for (int r = 0; r < k; r++) {
                if (dp[r] == 0) {
                    continue;
                }
                int newRemainder = (r * x) % k;
                cur[newRemainder] += dp[r];
            }
            for (int r = 0; r < k; r++) {
                ans[r] += cur[r];
            }
            dp = cur;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna