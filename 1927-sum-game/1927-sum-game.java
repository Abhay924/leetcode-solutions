class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int half=n/2;
        int diff=0;
        int leftQ=0,rightQ=0;
        for(int i=0;i<half;i++){
            if(num.charAt(i)=='?') leftQ++;
            else diff+=num.charAt(i)-'0';
        }
        for(int i=half;i<n;i++){
            if(num.charAt(i)=='?') rightQ++;
            else diff-=num.charAt(i)-'0';
        }
        int qDiff=leftQ-rightQ;
        if(qDiff==0)
            return diff!=0;
        if((qDiff&1)!=0)
            return true;
        return diff+qDiff/2*9!=0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna