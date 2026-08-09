class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i = prices.length - 1;
        int j = discounts.length - 1;
        double ans = 0;
        while (i >= 0) {
            if (j >= 0) {
                ans += prices[i] * (100.0 - discounts[j]) / 100.0;
                j--;
            } else {
                ans += prices[i];
            }
            i--;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna