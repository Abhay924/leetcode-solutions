class Solution {
    public int minMoves(int[] nums) {
        // The algorithm finds the minimum element and sums the differences.
        // This yields the minimum number of moves required.
        // Time Complexity: O(n) where n = nums.length (single pass to find min, another pass to sum differences).
        // Space Complexity: O(1) extra space (only a few integer variables).
        // This approach is optimal for this problem; no faster solution exists.
        // You can go ahead and submit this solution.
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        } 
        int moves = 0;
        for (int num : nums) {
            moves += num - min;
        }
        return moves;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna