class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            int stepCost = costs[i - 1]; 
            for (int j = Math.max(0, i - 3); j < i; j++) {
                int jumpDist = i - j;
                int jumpCost = stepCost + (jumpDist * jumpDist);
                f[i] = Math.min(f[i], f[j] + jumpCost);
            }
        }
        return f[n];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna