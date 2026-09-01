class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int sr = 0, sc = 0;
        List<int[]> litter = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }
        int k = litter.size();
        if (k == 0) return 0;
        int fullMask = (1 << k) - 1;
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << k];
        Queue<int[]> q = new ArrayDeque<>();
        visited[sr][sc][energy][0] = true;
        q.offer(new int[]{sr, sc, energy, 0, 0});
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];
            if (mask == fullMask) return moves;
            if (e == 0) continue;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (classroom[nr].charAt(nc) == 'X') continue;
                int ne = e - 1;
                int nmask = mask;
                char ch = classroom[nr].charAt(nc);
                if (ch == 'R') {
                    ne = energy;
                }
                if (ch == 'L') {
                    for (int i = 0; i < k; i++) {
                        if (litter.get(i)[0] == nr && litter.get(i)[1] == nc) {
                            nmask |= 1 << i;
                            break;
                        }
                    }
                }
                if (!visited[nr][nc][ne][nmask]) {
                    visited[nr][nc][ne][nmask] = true;
                    q.offer(new int[]{nr, nc, ne, nmask, moves + 1});
                }
            }
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna