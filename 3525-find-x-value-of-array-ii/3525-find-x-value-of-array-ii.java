class Solution {
    static class Node {
        int prod;
        long[] pref,suff,sub;
        Node(int k) {
            pref=new long[k];
            suff=new long[k];
            sub=new long[k];
        }
    }
    int k;
    Node[] tree;
    public int[] resultArray(int[] nums,int k,int[][] queries) {
        this.k=k;
        int n=nums.length;
        tree=new Node[4*n];
        build(1,0,n-1,nums);
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int[] q=queries[i];
            update(1,0,n-1,q[0],q[1]);
            Node res=query(1,0,n-1,q[2],n-1);
            ans[i]=(int)res.pref[q[3]];
        }
        return ans;
    }
    Node makeLeaf(int value) {
        Node res=new Node(k);
        int x=value%k;
        res.prod=x;
        res.pref[x]=1;
        res.suff[x]=1;
        res.sub[x]=1;
        return res;
    }
    void build(int node,int l,int r,int[] nums) {
        if(l==r) {
            tree[node]=makeLeaf(nums[l]);
            return;
        }
        int mid=(l+r)>>>1;
        build(node*2,l,mid,nums);
        build(node*2+1,mid+1,r,nums);
        tree[node]=merge(tree[node*2],tree[node*2+1]);
    }
    void update(int node,int l,int r,int pos,int value) {
        if(l==r) {
            tree[node]=makeLeaf(value);
            return;
        }
        int mid=(l+r)>>>1;
        if(pos<=mid) update(node*2,l,mid,pos,value);
        else update(node*2+1,mid+1,r,pos,value);
        tree[node]=merge(tree[node*2],tree[node*2+1]);
    }
    Node query(int node,int l,int r,int ql,int qr) {
        if(ql<=l&&r<=qr) return tree[node];
        int mid=(l+r)>>>1;
        if(qr<=mid) return query(node*2,l,mid,ql,qr);
        if(ql>mid) return query(node*2+1,mid+1,r,ql,qr);
        return merge(query(node*2,l,mid,ql,qr),query(node*2+1,mid+1,r,ql,qr));
    }
    Node merge(Node L,Node R) {
        Node res=new Node(k);
        res.prod=(L.prod*R.prod)%k;
        for(int i=0;i<k;i++) res.pref[i]+=L.pref[i];
        for(int i=0;i<k;i++) res.pref[(L.prod*i)%k]+=R.pref[i];
        for(int i=0;i<k;i++) res.suff[i]+=R.suff[i];
        for(int i=0;i<k;i++) res.suff[(i*R.prod)%k]+=L.suff[i];
        for(int i=0;i<k;i++) {
            res.sub[i]+=L.sub[i];
            res.sub[i]+=R.sub[i];
        }
        for(int i=0;i<k;i++)
            for(int j=0;j<k;j++)
                res.sub[(i*j)%k]+=L.suff[i]*R.pref[j];
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna