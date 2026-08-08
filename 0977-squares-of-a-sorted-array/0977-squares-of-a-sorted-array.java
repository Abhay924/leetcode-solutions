class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int l=0,r=n-1,k=n-1;
        while(l<=r){
            if(Math.abs(nums[l])>Math.abs(nums[r])){
                ans[k--]=nums[l]*nums[l];
                l++;
            }else{
                ans[k--]=nums[r]*nums[r];
                r--;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna