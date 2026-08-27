class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] total = new int[26];
        for (char c : s.toCharArray()) {
            total[c - 'a']++;
        }
        int[][] prefix = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                prefix[i + 1][j] = prefix[i][j];
            }
            prefix[i + 1][target.charAt(i) - 'a']++;
        }
        for (int i = n - 1; i >= 0; i--) {
            boolean possible = true;
            for (int c = 0; c < 26; c++) {
                if (prefix[i][c] > total[c]) {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                continue;
            }
            int[] remaining = new int[26];
            for (int c = 0; c < 26; c++) {
                remaining[c] = total[c] - prefix[i][c];
            }
            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    StringBuilder ans = new StringBuilder();
                    ans.append(target, 0, i);
                    ans.append((char) ('a' + c));
                    remaining[c]--;
                    for (int x = 0; x < 26; x++) {
                        while (remaining[x] > 0) {
                            ans.append((char) ('a' + x));
                            remaining[x]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }
        return "";
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna