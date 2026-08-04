class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean[] present = new boolean[101];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            present[num] = true;
        }
        for (int i = min; i <= max; i++) {
            if (!present[i]) ans.add(i);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna