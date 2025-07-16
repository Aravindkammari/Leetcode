class Solution {
    public int maximumLength(int[] nums) {
        int even = 0;
        int odd = 0;
        for(int n : nums){
            if(n % 2 == 0)even++;
            else odd++;
        }
        int state = nums[0] % 2;
        int alternating = 1;
        for(int i = 1; i < nums.length; i++){
            int currentState = nums[i] % 2;
            if(state != currentState){
                alternating++;
                state = currentState;
            }
        }
        return Math.max(even, Math.max(odd, alternating));
    }
}