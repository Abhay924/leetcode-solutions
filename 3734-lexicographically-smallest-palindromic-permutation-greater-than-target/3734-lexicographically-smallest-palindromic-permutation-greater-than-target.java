class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int odd = 0;
        int middle = -1;
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd++;
                middle = i;
            }
        }
        if (odd > 1) return "";
        int len = n / 2;
        int[] half = new int[26];
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }
        char[] left = new char[len];
        int p = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < half[i]; j++) {
                left[p++] = (char)('a' + i);
            }
        }
        String smallest = makePalindrome(left, middle, n);
        if (smallest.compareTo(target) > 0) {
            return smallest;
        }
        String prefix = target.substring(0, len);
        int[] count = half.clone();
        boolean possible = true;
        for (int i = 0; i < len; i++) {
            int c = prefix.charAt(i) - 'a';
            count[c]--;
            if (count[c] < 0) {
                possible = false;
                break;
            }
        }
        if (possible) {
            String candidate = makePalindrome(prefix.toCharArray(), middle, n);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }
        for (int pos = len - 1; pos >= 0; pos--) {
            int[] rem = half.clone();
            boolean valid = true;
            for (int i = 0; i < pos; i++) {
                int c = prefix.charAt(i) - 'a';
                rem[c]--;
                if (rem[c] < 0) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;
            int cur = prefix.charAt(pos) - 'a';
            for (int c = cur + 1; c < 26; c++) {
                if (rem[c] == 0) continue;
                char[] result = new char[len];
                for (int i = 0; i < pos; i++) {
                    result[i] = prefix.charAt(i);
                }
                result[pos] = (char)('a' + c);
                rem[c]--;
                int idx = pos + 1;
                for (int x = 0; x < 26; x++) {
                    while (rem[x] > 0) {
                        result[idx++] = (char)('a' + x);
                        rem[x]--;
                    }
                }
                String ans = makePalindrome(result, middle, n);
                if (ans.compareTo(target) > 0) {
                    return ans;
                }
            }
        }
        return "";
    }
    private String makePalindrome(char[] left, int middle, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(left);
        if ((n & 1) == 1) {
            sb.append((char)('a' + middle));
        }
        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna