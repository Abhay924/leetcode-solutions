class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[101];
            int distinct = 0;
            for (int j = i; j < n; j++) {
                int num = nums.get(j);
                if (!seen[num]) {
                    seen[num] = true;
                    distinct++;
                }
                ans += distinct * distinct;
            }
        }
        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna