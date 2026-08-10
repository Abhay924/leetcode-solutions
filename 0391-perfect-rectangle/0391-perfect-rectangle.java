class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        long area = 0;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] r : rectangles) {
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            area += (long) (x2 - x1) * (y2 - y1);
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);
            String[] corners = {
                x1 + "," + y1,
                x1 + "," + y2,
                x2 + "," + y1,
                x2 + "," + y2
            };
            for (String corner : corners) {
                if (!set.add(corner)) set.remove(corner);
            }
        }
        long totalArea = (long) (maxX - minX) * (maxY - minY);
        if (area != totalArea || set.size() != 4) return false;
        return set.contains(minX + "," + minY)
            && set.contains(minX + "," + maxY)
            && set.contains(maxX + "," + minY)
            && set.contains(maxX + "," + maxY);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna