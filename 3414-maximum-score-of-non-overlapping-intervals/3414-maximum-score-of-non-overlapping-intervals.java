class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[3], b[3]);
        });
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int lo = 0;
            int hi = i - 1;
            int ans = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid][1] < arr[i][0]) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            prev[i] = ans;
        }
        State[][] dp = new State[n + 1][5];
        for (int k = 0; k <= 4; k++) {
            dp[0][k] = new State(0, new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = dp[i - 1][k];
            }
            for (int k = 1; k <= 4; k++) {
                int p = prev[i - 1] + 1;
                State previous = dp[p][k - 1];
                long newScore = previous.score + arr[i - 1][2];
                List<Integer> newIndices = new ArrayList<>(previous.indices);
                newIndices.add(arr[i - 1][3]);
                Collections.sort(newIndices);
                State take = new State(newScore, newIndices);
                if (better(take, dp[i][k])) {
                    dp[i][k] = take;
                }
            }
        }
        State answer = dp[n][0];
        for (int k = 1; k <= 4; k++) {
            if (better(dp[n][k], answer)) {
                answer = dp[n][k];
            }
        }
        int[] result = new int[answer.indices.size()];
        for (int i = 0; i < answer.indices.size(); i++) {
            result[i] = answer.indices.get(i);
        }
        return result;
    }

    private boolean better(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score;
        }
        return compareLexicographically(a.indices, b.indices) < 0;
    }

    private int compareLexicographically(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return Integer.compare(a.size(), b.size());
    }
    static class State {
        long score;
        List<Integer> indices;
        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna