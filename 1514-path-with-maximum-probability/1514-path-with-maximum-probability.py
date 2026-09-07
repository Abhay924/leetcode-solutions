
class Solution:
    def maxProbability(self, n, edges, succProb, start, end):
        graph = [[] for _ in range(n)]
        for i, (u, v) in enumerate(edges):
            graph[u].append((v, succProb[i]))
            graph[v].append((u, succProb[i]))
        prob = [0.0] * n
        prob[start] = 1.0
        pq = [(-1.0, start)]
        while pq:
            curr_prob, node = heapq.heappop(pq)
            curr_prob = -curr_prob
            if node == end:
                return curr_prob
            if curr_prob < prob[node]:
                continue
            for nei, edge_prob in graph[node]:
                new_prob = curr_prob * edge_prob
                if new_prob > prob[nei]:
                    prob[nei] = new_prob
                    heapq.heappush(pq, (-new_prob, nei))
        return 0.0

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna