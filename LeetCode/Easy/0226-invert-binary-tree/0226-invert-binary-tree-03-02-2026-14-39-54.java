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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currNode = queue.poll();
                TreeNode temp = currNode.left;
                currNode.left = currNode.right;
                currNode.right = temp;
                if(currNode.left!=null){
                    queue.add(currNode.left);
                } 
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
        }
        return root;
    }
}