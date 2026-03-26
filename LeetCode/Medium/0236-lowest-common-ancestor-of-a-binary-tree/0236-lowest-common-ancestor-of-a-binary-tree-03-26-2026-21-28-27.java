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
    public TreeNode lca=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isPresent(root,p,q);
        return lca;
    }
    public boolean isPresent(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return false;
        }
        int isRoot=(root==p||root==q)?1:0;
        int left=isPresent(root.left,p,q)?1:0;
        int right=isPresent(root.right,p,q)?1:0;
        if(isRoot+left+right>=2){
            lca=root;
        }
        return isRoot+left+right>0;
    }
}