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
    ArrayList<Integer> list = new ArrayList<>();
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        int ans = helper(root);
        Collections.sort(list);
        if(list.size() < k)return -1;
        return list.get(list.size() - k);
    }
    int helper(TreeNode root){
        if(root == null)return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left != -1 && left == right){
            list.add(left * 2 + 1);
            return left * 2 + 1;
        }
        return -1;
    }
}