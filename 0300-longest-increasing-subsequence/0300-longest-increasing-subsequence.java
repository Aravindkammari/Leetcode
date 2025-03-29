class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(dp[i] != -1)continue;
            max = Math.max(max, helper(nums, dp, i));
        }
        return max;
    }
    int helper(int[] nums, int[] dp, int i){
        if(dp[i] != -1)return dp[i];
        int max = 1;
        for(int j = i+1; j < nums.length; j++){
            if(nums[j] > nums[i]){
                max = Math.max(max, 1 + helper(nums, dp, j));
            }
        }
        return dp[i] = max;
    }
}