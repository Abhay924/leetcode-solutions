class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];

        for(int i=0;i<n;i++) dp[i]=i;

        for(int center=0;center<n;center++){
            expand(s,center,center,dp);
            expand(s,center,center+1,dp);
        }

        return dp[n-1];
    }

    private void expand(String s,int l,int r,int[] dp) {
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            if(l==0) dp[r]=0;
            else dp[r]=Math.min(dp[r],dp[l-1]+1);
            l--;
            r++;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna