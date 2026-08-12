class Solution {
    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length() - 1, k);
    }
    private int solve(String s, int left, int right, int k) {
        if (right - left + 1 < k) return 0;
        int[] freq = new int[26];
        for (int i = left; i <= right; i++) freq[s.charAt(i) - 'a']++;
        for (int i = left; i <= right; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j <= right && freq[s.charAt(j) - 'a'] < k) j++;
                return Math.max(solve(s, left, i - 1, k), solve(s, j, right, k));
            }
        }
        return right - left + 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna