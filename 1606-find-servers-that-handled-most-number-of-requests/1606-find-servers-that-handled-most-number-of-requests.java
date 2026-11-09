class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requestCounts = new int[k];
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i];
            int duration = load[i];
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= start) {
                int[] freeServer = busyServers.poll();
                availableServers.add(freeServer[1]);
            }
            if (availableServers.isEmpty()) {
                continue;
            }
            int target = i % k;
            Integer chosenServer = availableServers.ceiling(target);
            if (chosenServer == null) {
                chosenServer = availableServers.first();
            }
            
            availableServers.remove(chosenServer);
            requestCounts[chosenServer]++;
            busyServers.offer(new int[]{start + duration, chosenServer});
        }
        int maxRequests = 0;
        for (int count : requestCounts) {
            maxRequests = Math.max(maxRequests, count);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCounts[i] == maxRequests) {
                result.add(i);
            }
        }
        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna