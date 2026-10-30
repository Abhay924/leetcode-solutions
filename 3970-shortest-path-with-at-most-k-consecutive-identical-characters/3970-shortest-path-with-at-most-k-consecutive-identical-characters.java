class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) return 0;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int consec = curr[2];
            if (u == n - 1) return cost;
            if (cost > dist[u][consec]) continue;
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                int nextConsec = (labels.charAt(u) == labels.charAt(v)) ? consec + 1 : 1;
                if (nextConsec > k) continue;
                if (cost + w < dist[v][nextConsec]) {
                    dist[v][nextConsec] = cost + w;
                    pq.offer(new int[]{cost + w, v, nextConsec});
                }
            }
        }
        return -1;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna