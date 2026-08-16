class Solution {
    public long maxScore(int[] nums1,int[] nums2,int k) {
        int n=nums1.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++) idx[i]=i;
        Arrays.sort(idx,(a,b)->Integer.compare(nums2[b],nums2[a]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long sum=0;
        long ans=0;
        for(int i:idx){
            pq.offer(nums1[i]);
            sum+=nums1[i];
            if(pq.size()>k)
                sum-=pq.poll();
            if(pq.size()==k)
                ans=Math.max(ans,sum*nums2[i]);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna