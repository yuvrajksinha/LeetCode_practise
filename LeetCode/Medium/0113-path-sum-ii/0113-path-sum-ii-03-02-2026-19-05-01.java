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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root,targetSum,list,lists);
        return lists;
    }
    public void dfs(TreeNode root,int targetSum, List<Integer> list, List<List<Integer>> lists){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0){
                lists.add(new ArrayList<>(list));
            }
        }
        dfs(root.left,targetSum-root.val,list,lists);
        dfs(root.right,targetSum-root.val,list,lists);
        list.remove(list.size()-1);
    }
}