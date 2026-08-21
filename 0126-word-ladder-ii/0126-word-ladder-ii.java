class Solution {
    public List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList) {
        List<List<String>> ans=new ArrayList<>();
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return ans;
        Map<String,List<String>> parents=new HashMap<>();
        Set<String> current=new HashSet<>();
        current.add(beginWord);
        boolean found=false;

        while(!current.isEmpty()&&!found){
            set.removeAll(current);
            Set<String> nextLevel=new HashSet<>();
            for(String word:current){
                char[] chars=word.toCharArray();
                for(int i=0;i<chars.length;i++){
                    char old=chars[i];
                    for(char c='a';c<='z';c++){
                        if(c==old) continue;
                        chars[i]=c;
                        String next=new String(chars);
                        if(!set.contains(next)) continue;
                        nextLevel.add(next);
                        parents.computeIfAbsent(next,x->new ArrayList<>()).add(word);
                        if(next.equals(endWord)) found=true;
                    }
                    chars[i]=old;
                }
            }
            current=nextLevel;
        }
        if(!found) return ans;
        List<String> path=new ArrayList<>();
        path.add(endWord);
        dfs(endWord,beginWord,parents,path,ans);
        return ans;
    }

    void dfs(String word,String beginWord,Map<String,List<String>> parents,List<String> path,List<List<String>> ans){
        if(word.equals(beginWord)){
            List<String> temp=new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        if(!parents.containsKey(word)) return;
        for(String parent:parents.get(word)){
            path.add(parent);
            dfs(parent,beginWord,parents,path,ans);
            path.remove(path.size()-1);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna