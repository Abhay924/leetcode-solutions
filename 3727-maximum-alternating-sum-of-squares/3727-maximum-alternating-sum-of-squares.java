class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        for (int i = 0; i < n; i++) {
            long x = nums[i];
            squares[i] = x * x;
        }
        Arrays.sort(squares);
        long ans = 0;
        int half = n / 2;
        for (int i = 0; i < half; i++) {
            ans -= squares[i];
        }
        for (int i = half; i < n; i++) {
            ans += squares[i];
        }
        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna