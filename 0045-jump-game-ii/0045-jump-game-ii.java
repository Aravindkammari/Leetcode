class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, dp, 0);
    }
    int helper(int[] nums, int[] dp, int i){
        if(i >= nums.length-1)return 0;
        if(dp[i] != -1)return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j = i + 1; j <= Math.min(nums.length -1, i + nums[i]); j++){
            int jumps = helper(nums, dp, j);
            if(jumps != Integer.MAX_VALUE){
                min = Math.min(min, jumps + 1);
            }
        }
        return dp[i] = min;
    }
}