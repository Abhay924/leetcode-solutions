class Solution:
    def sortableIntegers(self, nums: list[int]) -> int:
        n = len(nums)
        ans = 0
        for k in range(1, n + 1):
            if n % k != 0:
                continue
            valid = True
            prev_max = float("-inf")
            for start in range(0, n, k):
                block = nums[start:start + k]
                descents = sum(
                    block[i] > block[(i + 1) % k]
                    for i in range(k)
                )
                if descents > 1:
                    valid = False
                    break
                block_min = min(block)
                block_max = max(block)
                if prev_max > block_min:
                    valid = False
                    break
                prev_max = block_max
            if valid:
                ans += k
        return ans

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna