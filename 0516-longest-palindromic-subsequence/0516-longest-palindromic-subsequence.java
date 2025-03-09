class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(dp, s, 0, n-1);
    }
    int helper(int[][] dp, String s, int low, int high){
        if(low > high)return 0;
        if(low == high)return 1;
        if(dp[low][high] != -1)return dp[low][high];
        if(s.charAt(low) == s.charAt(high)){
            return dp[low][high] = 2 + helper(dp, s, low+1, high-1);
        }
        int right = helper(dp, s, low + 1, high);
        int left = helper(dp, s, low, high - 1);
        return dp[low][high] = Math.max(right, left);
    }
}