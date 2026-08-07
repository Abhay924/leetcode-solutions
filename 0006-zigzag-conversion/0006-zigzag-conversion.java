class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1||numRows>=s.length()) return s;
        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) rows[i]=new StringBuilder();
        int cur=0;
        boolean down=true;
        for(char c:s.toCharArray()){
            rows[cur].append(c);
            if(cur==0) down=true;
            else if(cur==numRows-1) down=false;
            cur+=down?1:-1;
        }
        StringBuilder ans=new StringBuilder();
        for(StringBuilder row:rows) ans.append(row);
        return ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna