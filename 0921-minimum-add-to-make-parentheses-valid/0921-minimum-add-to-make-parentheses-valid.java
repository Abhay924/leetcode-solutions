class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    ans++;
                }
            }
        }
        return ans + balance;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna