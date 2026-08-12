class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        StringBuilder chars = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                for (int j = 0; j < freq[i] / k; j++) chars.append((char) ('a' + i));
            }
        }
        String best = "";
        Queue<String> q = new ArrayDeque<>();
        q.offer("");
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.length() > best.length() || cur.length() == best.length() && cur.compareTo(best) > 0) best = cur;
            for (int i = 0; i < chars.length(); i++) {
                char c = chars.charAt(i);
                String next = cur + c;
                if (next.length() > s.length() / k) continue;
                if (check(s, next, k)) q.offer(next);
            }
        }
        return best;
    }
    private boolean check(String s, String t, int k) {
        int j = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == t.charAt(j)) {
                j++;
                if (j == t.length()) {
                    count++;
                    j = 0;
                    if (count == k) return true;
                }
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna