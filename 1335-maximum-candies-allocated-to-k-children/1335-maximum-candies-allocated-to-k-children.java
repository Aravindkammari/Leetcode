class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for(int i : candies){
            max = Math.max(max, i);
        }
        int low = 1, high = max;
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            long totalPiles = total(mid, candies);
            if(totalPiles >= k){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public long total(int mid, int[] candies){
        long ans = 0;
        for(int i : candies){
            ans += i/mid;
        }
        return ans;
    }
}