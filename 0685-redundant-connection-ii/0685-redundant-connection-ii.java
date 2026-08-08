class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] cand1 = null, cand2 = null;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};
                edge[1] = 0;
            }
        }

        int[] uf = new int[n + 1];
        for (int i = 1; i <= n; i++) uf[i] = i;
        for (int[] edge : edges) {
            if (edge[1] == 0) continue;
            int u = edge[0], v = edge[1];
            int pu = find(uf, u);
            if (pu == v) {
                return cand1 == null ? edge : cand1;
            }
            uf[v] = pu;
        }
        return cand2;
    }

    private int find(int[] uf, int x) {
        if (uf[x] != x) uf[x] = find(uf, uf[x]);
        return uf[x];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna