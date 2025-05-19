class Solution {
    public String triangleType(int[] nums) {
       int count = 1;
       for(int i = 1; i < 3; i++){
        if(i == 1 && nums[i] + nums[i - 1] <= nums[i + 1])return "none";
        if(i == 2 && (nums[i] + nums[i - 1] <= nums[0] || nums[0] + nums[i] <= nums[i - 1]))return "none";
        if(i == 1 && nums[i] == nums[i-1])count++;
        if(i == 2 && (nums[i] == nums[i-1] || nums[i] == nums[i-2]))count++;
       }
       if(count == 1)return "scalene";
       if(count == 2)return "isosceles";
       return "equilateral";
    }
}