class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) {
                continue;
            }
            int left = first[c];
            int right = last[c];
            boolean valid = true;
            for (int i = left; i <= right; i++) {
                int current = s.charAt(i) - 'a';
                if (first[current] < left) {
                    valid = false;
                    break;
                }
                right = Math.max(right, last[current]);
            }
            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }
        intervals.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(
                    a[1] - a[0],
                    b[1] - b[0]
            );
        });
        List<String> result = new ArrayList<>();
        int previousEnd = -1;
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (left > previousEnd) {
                result.add(s.substring(left, right + 1));
                previousEnd = right;
            }
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna