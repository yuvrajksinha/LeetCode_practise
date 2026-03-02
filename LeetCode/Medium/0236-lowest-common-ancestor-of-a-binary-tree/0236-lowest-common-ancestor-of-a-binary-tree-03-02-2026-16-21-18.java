/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return lca;
    }
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return false;
        }
        int left = dfs(root.left,p,q)?1:0; //in left subtree
        int right = dfs(root.right,p,q)?1:0; //in right subtree
        int mid = (root == p || root == q)?1:0; //the root itself is one of the two
        if(left+right+mid==2){ //if two of the three conditions are true of root then we have our lca
            lca = root;
        }
        return (left+right+mid)>0;
    }
}