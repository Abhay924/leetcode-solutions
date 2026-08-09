class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] lps = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) j = lps[j - 1];
            if (combined.charAt(i) == combined.charAt(j)) j++;
            lps[i] = j;
        }
        int len = lps[combined.length() - 1];
        String suffix = s.substring(len);
        return new StringBuilder(suffix).reverse().append(s).toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna