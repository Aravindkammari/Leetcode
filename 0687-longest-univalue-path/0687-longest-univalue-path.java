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
    int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root, -1);
        return maxPath;
    }
    int helper(TreeNode root, int parent){
        if(root == null) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        maxPath = Math.max(maxPath, left + right);
        if(root.val == parent){
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}