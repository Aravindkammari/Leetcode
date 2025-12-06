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
    int max = 0;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        int ans = helper(root);
        return max;
    }
    int helper(TreeNode root){
        if(root == null)return Integer.MIN_VALUE;
        if(root.left == null && root.right == null)return root.val;
        int left = helper(root.left);
        int right = helper(root.right);
        int x = left;
        int y = right;
        max = Math.max(max, Math.max(left, right));
        if(left == Integer.MIN_VALUE)left = 0;
        if(right == Integer.MIN_VALUE)right = 0;
        max = Math.max(max, left + right + root.val);
        return Math.max(x, y) + root.val;
    }
}