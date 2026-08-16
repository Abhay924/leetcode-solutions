class Solution {
    public double mincostToHireWorkers(int[] quality,int[] wage,int k) {
        int n=quality.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++) idx[i]=i;
        Arrays.sort(idx,(a,b)->Double.compare((double)wage[a]/quality[a],(double)wage[b]/quality[b]));
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;
        double ans=Double.MAX_VALUE;
        for(int i:idx){
            pq.offer(quality[i]);
            sum+=quality[i];
            if(pq.size()>k)
                sum-=pq.poll();
            if(pq.size()==k)
                ans=Math.min(ans,sum*((double)wage[i]/quality[i]));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna