class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return (int) mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }
    private long mergeSort(long[] sums, int left, int right, int lower, int upper) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        long count = mergeSort(sums, left, mid, lower, upper) + mergeSort(sums, mid + 1, right, lower, upper);
        int lo = mid + 1, hi = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (lo <= right && sums[lo] - sums[i] < lower) lo++;
            while (hi <= right && sums[hi] - sums[i] <= upper) hi++;
            count += hi - lo;
        }
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (sums[i] <= sums[j]) temp[k++] = sums[i++];
            else temp[k++] = sums[j++];
        }
        while (i <= mid) temp[k++] = sums[i++];
        while (j <= right) temp[k++] = sums[j++];
        System.arraycopy(temp, 0, sums, left, temp.length);
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna