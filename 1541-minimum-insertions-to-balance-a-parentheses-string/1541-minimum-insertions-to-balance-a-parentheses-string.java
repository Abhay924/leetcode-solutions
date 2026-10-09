class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
                if (i > 0 && s.charAt(i - 1) == '(') {
                }
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    insertions++;
                }
                if (open > 0) {
                    open--;
                } else {
                    insertions++;
                }
            }
        }
        insertions += open * 2;
        return insertions;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna