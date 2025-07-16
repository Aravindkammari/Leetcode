class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = helper(nums, target, 0, dp);
        return ans < 0 ? -1 : ans;
    }
    int helper(List<Integer> nums, int target, int idx, int[][]dp){
        if(target == 0)return 0;
        if(idx >= nums.size() || target < 0)return Integer.MIN_VALUE;
        if(dp[idx][target] != -1)return dp[idx][target];
        int take = Integer.MIN_VALUE;
        if(nums.get(idx) <= target){
            int res = helper(nums, target - nums.get(idx), idx + 1, dp);
            if(res != Integer.MIN_VALUE){
                take = 1 + res;
            }
        }
        int noTake = helper(nums, target, idx + 1, dp);
        return dp[idx][target] = Math.max(take, noTake);
    }
}