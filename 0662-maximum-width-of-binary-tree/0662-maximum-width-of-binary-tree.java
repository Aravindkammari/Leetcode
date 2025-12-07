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
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;
        while(!q.isEmpty()){
            int n = q.size();
            int first = 0;
            int last = 0;
            for(int i = 0; i < n; i++){
                TreeNode curr = q.peek().node;
                int num = q.peek().num;
                if(i == 0)first = num;
                if(i == n - 1)last = num;
                q.poll();
                if(curr.left != null){
                    q.offer(new Pair(curr.left, 2 * num + 1));
                }
                if(curr.right != null){
                    q.offer(new Pair(curr.right, 2 * num + 2));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        } 
        return maxWidth;
    }
}