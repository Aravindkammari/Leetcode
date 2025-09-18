class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n && nums[i] == 0)i++;
        int j = 0;
        for(; i < n; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        while(j < n){
            nums[j] = 0;
            j++;
        }
    }
}