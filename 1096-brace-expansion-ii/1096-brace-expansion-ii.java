class Solution {
    int i = 0;
    public List<String> braceExpansionII(String expression) {
        Set<String> ans = parse(expression);
        List<String> res = new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }
    Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        result.add("");
        while (i < s.length() && s.charAt(i) != '}') {
            if (s.charAt(i) == ',') {
                i++;
                Set<String> right = parse(s);
                result.addAll(right);
                return result;
            }
            Set<String> part;
            if (s.charAt(i) == '{') {
                i++;
                part = parse(s);
                i++;
            } else {
                part = new HashSet<>();
                part.add(String.valueOf(s.charAt(i)));
                i++;
            }
            Set<String> temp = new HashSet<>();
            for (String a : result) {
                for (String b : part) {
                    temp.add(a + b);
                }
            }
            result = temp;
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna