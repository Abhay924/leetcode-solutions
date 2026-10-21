class Solution:
    def minOperations(self, s: str) -> int:
        if s == ''.join(sorted(s)):
            return 0
        n = len(s)
        if n == 2:
            return -1
        if n == 3:
            if s[0] <= s[1] <= s[2]:
                return 0
            if s[0] <= s[2] <= s[1] or s[1] <= s[0] <= s[2]:
                return 1
            return 2
        first = s[0]
        last = s[-1]
        if first == min(s) or last == max(s):
            return 1
        if first == max(s) and last == min(s):
            if s.count(first) == 1 and s.count(last) == 1:
                return 3
        return 2

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna