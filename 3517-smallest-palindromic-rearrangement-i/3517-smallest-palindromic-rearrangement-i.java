class Solution {
    public String smallestPalindrome(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray())freq[c-'a']++;
        StringBuilder half=new StringBuilder();
        char mid=0;
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i]/2;j++)half.append((char)(i+'a'));
            if(freq[i]%2==1)mid=(char)(i+'a');
        }
        StringBuilder ans=new StringBuilder(half);
        if(mid!=0)ans.append(mid);
        ans.append(new StringBuilder(half).reverse());
        return ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna