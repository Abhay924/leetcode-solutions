class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int[] dp=nums.clone();
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[j]=Math.max(nums[i]-dp[j],nums[j]-dp[j-1]);
            }
        }
        return dp[n-1]>=0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna