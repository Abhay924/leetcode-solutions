class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int answer = 0;
        for (int dr = -(n - 1); dr <= n - 1; dr++) {
            for (int dc = -(n - 1); dc <= n - 1; dc++) {
                int overlap = 0;
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        int nr = r + dr;
                        int nc = c + dc;
                        if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < n) {
                            if (img1[r][c] == 1 &&
                                img2[nr][nc] == 1) {
                                overlap++;
                            }
                        }
                    }
                }
                answer = Math.max(answer, overlap);
            }
        }
        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna