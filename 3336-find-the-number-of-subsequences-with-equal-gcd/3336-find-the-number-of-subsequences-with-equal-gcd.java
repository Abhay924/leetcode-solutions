class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] dp;

    public int subsequencePairCount(int[] nums) {
        dp = new int[nums.length][201][201];
        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }
        return dfs(nums, 0, 0, 0);
    }
    private int dfs(int[] nums, int idx, int g1, int g2) {
        if (idx == nums.length) {
            return (g1 != 0 && g2 != 0 && g1 == g2) ? 1 : 0;
        }

        if (dp[idx][g1][g2] != -1)
            return dp[idx][g1][g2];

        long ans = 0;
        ans += dfs(nums, idx + 1, gcd(g1, nums[idx]), g2);
        ans += dfs(nums, idx + 1, g1, gcd(g2, nums[idx]));
        ans += dfs(nums, idx + 1, g1, g2);
        return dp[idx][g1][g2] = (int)(ans % MOD);
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna