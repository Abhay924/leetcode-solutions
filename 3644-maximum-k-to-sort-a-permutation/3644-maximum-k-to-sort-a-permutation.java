class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                k &= nums[i] & i;
            }
        }
        return k == -1 ? 0 : k;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna