/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] height=new int[100001];
    int[] ans=new int[100001];
    public int[] treeQueries(TreeNode root,int[] queries){
        getHeight(root);
        dfs(root,0,0);
        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++) result[i]=ans[queries[i]];
        return result;
    }
    private int getHeight(TreeNode node){
        if(node==null) return -1;
        int left=getHeight(node.left);
        int right=getHeight(node.right);
        height[node.val]=1+Math.max(left,right);
        return height[node.val];
    }
    private void dfs(TreeNode node,int depth,int outside){
        if(node==null) return;
        ans[node.val]=outside;
        int leftHeight=node.left==null?-1:height[node.left.val];
        int rightHeight=node.right==null?-1:height[node.right.val];
        int leftOutside=Math.max(outside,depth+1+rightHeight);
        int rightOutside=Math.max(outside,depth+1+leftHeight);
        dfs(node.left,depth+1,leftOutside);
        dfs(node.right,depth+1,rightOutside);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna