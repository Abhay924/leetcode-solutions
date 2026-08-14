class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq=new int[26];
        int left=0,ans=0;
        for(int right=0;right<s.length();right++){
            int c=s.charAt(right)-'a';
            freq[c]++;
            while(freq[c]>2){
                freq[s.charAt(left)-'a']--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna