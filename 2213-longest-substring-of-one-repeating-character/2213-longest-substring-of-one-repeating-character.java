class Solution {
    class Node {
        char leftChar,rightChar;
        int len,prefix,suffix,best;
        Node(char c){
            leftChar=rightChar=c;
            len=1;
            prefix=suffix=best=1;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String str,String queryCharacters,int[] queryIndices) {
        s=str.toCharArray();
        int n=s.length;
        tree=new Node[4*n];
        build(1,0,n-1);

        int[] ans=new int[queryIndices.length];

        for(int i=0;i<queryIndices.length;i++){
            update(1,0,n-1,queryIndices[i],queryCharacters.charAt(i));
            ans[i]=tree[1].best;
        }

        return ans;
    }

    void build(int node,int l,int r){
        if(l==r){
            tree[node]=new Node(s[l]);
            return;
        }

        int mid=(l+r)/2;
        build(node*2,l,mid);
        build(node*2+1,mid+1,r);
        tree[node]=merge(tree[node*2],tree[node*2+1]);
    }

    Node merge(Node a,Node b){
        Node c=new Node(a.leftChar);
        c.leftChar=a.leftChar;
        c.rightChar=b.rightChar;
        c.len=a.len+b.len;

        c.prefix=a.prefix;
        if(a.prefix==a.len&&a.rightChar==b.leftChar)
            c.prefix=a.len+b.prefix;

        c.suffix=b.suffix;
        if(b.suffix==b.len&&a.rightChar==b.leftChar)
            c.suffix=b.len+a.suffix;

        c.best=Math.max(a.best,b.best);

        if(a.rightChar==b.leftChar)
            c.best=Math.max(c.best,a.suffix+b.prefix);

        return c;
    }

    void update(int node,int l,int r,int idx,char ch){
        if(l==r){
            tree[node]=new Node(ch);
            s[idx]=ch;
            return;
        }

        int mid=(l+r)/2;

        if(idx<=mid)
            update(node*2,l,mid,idx,ch);
        else
            update(node*2+1,mid+1,r,idx,ch);

        tree[node]=merge(tree[node*2],tree[node*2+1]);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna