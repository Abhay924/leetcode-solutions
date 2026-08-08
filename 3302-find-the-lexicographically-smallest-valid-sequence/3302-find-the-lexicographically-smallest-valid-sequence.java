public class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] suf = new int[n + 1];
        suf[n] = m;
        
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
        }
        int[] ans = new int[m];
        int idx = 0;
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            if (idx == m) {
                break;
            }
            if (word1.charAt(i) == word2.charAt(idx) || (!changed && suf[i + 1] <= idx + 1)) {
                if (word1.charAt(i) != word2.charAt(idx)) {
                    changed = true;
                }
                ans[idx] = i;
                idx++;
            }
        }
        return idx == m ? ans : new int[0];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna