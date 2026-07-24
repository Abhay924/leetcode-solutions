class Solution {
    public int uniqueXorTriplets(int[] nums) {
         final int MAX = 2048;
        boolean[] present = new boolean[MAX];
        for (int x : nums) {
            present[x] = true;
        }
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            if (present[i]) values.add(i);
        }

        boolean[] pairXor = new boolean[MAX];
        for (int a : values) {
            for (int b : values) {
                pairXor[a ^ b] = true;
            }
        }
        boolean[] ans = new boolean[MAX];
        for (int x = 0; x < MAX; x++) {
            if (!pairXor[x]) continue;
            for (int v : values) {
                ans[x ^ v] = true;
            }
        }
        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna