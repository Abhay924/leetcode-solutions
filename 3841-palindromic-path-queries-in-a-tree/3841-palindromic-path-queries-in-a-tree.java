class Solution {
    private List<Integer>[] adj;
    private int[] tin, tout, depth, parent;
    private int[][] up;
    private int[] bit;
    private int timer, LOG;
    private char[] chars;
    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        chars = s.toCharArray();
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];
        int[] stack = new int[n];
        int[] next = new int[n];
        int top = 0;
        stack[0] = 0;
        parent[0] = 0;
        timer = 0;
        tin[0] = timer++;
        while (top >= 0) {
            int u = stack[top];
            if (next[u] < adj[u].size()) {
                int v = adj[u].get(next[u]++);
                if (v == parent[u]) continue;
                parent[v] = u;
                depth[v] = depth[u] + 1;
                tin[v] = timer++;
                stack[++top] = v;
            } else {
                tout[u] = timer++;
                top--;
            }
        }
        LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        up = new int[LOG][n];
        for (int i = 0; i < n; i++) {
            up[0][i] = parent[i];
        }
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }
        bit = new int[2 * n + 1];
        for (int u = 0; u < n; u++) {
            int mask = 1 << (chars[u] - 'a');
            add(tin[u], mask);
            add(tout[u], mask);
        }
        List<Boolean> answer = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');
                int delta = oldMask ^ newMask;
                add(tin[u], delta);
                add(tout[u], delta);
                chars[u] = c;
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int w = lca(u, v);
                int mask = prefix(tin[u])
                         ^ prefix(tin[v])
                         ^ (1 << (chars[w] - 'a'));

                answer.add((mask & (mask - 1)) == 0);
            }
        }
        return answer;
    }
    private void add(int pos, int value) {
        for (int i = pos + 1; i < bit.length; i += i & -i) {
            bit[i] ^= value;
        }
    }
    private int prefix(int pos) {
        int res = 0;
        for (int i = pos + 1; i > 0; i -= i & -i) {
            res ^= bit[i];
        }
        return res;
    }
    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }
        if (u == v) return u;
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }
        return parent[u];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna