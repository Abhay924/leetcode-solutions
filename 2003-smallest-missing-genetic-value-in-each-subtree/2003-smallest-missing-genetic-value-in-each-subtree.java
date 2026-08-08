class Solution {
    List<Integer>[] tree;
    boolean[] seenNode;
    boolean[] seenValue;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) tree[parents[i]].add(i);

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int node = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                node = i;
                break;
            }
        }

        if (node == -1) return ans;

        seenNode = new boolean[n];
        seenValue = new boolean[100002];
        int missing = 1;

        while (node != -1) {
            dfs(node, nums);
            while (seenValue[missing]) missing++;
            ans[node] = missing;
            node = parents[node];
        }

        return ans;
    }

    private void dfs(int u, int[] nums) {
        if (seenNode[u]) return;
        seenNode[u] = true;
        seenValue[nums[u]] = true;
        for (int v : tree[u]) dfs(v, nums);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna