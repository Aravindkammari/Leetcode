class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(dp, nums, target);
    }
    public int helper(int[] dp, int[] nums, int target){
        if(target < 0)return 0;
        if(target == 0) return 1;
        if(dp[target] != -1)return dp[target];
        int ways = 0;
        for(int i : nums){
            ways += helper(dp, nums, target-i);
        }
        return dp[target] = ways;
    }
}