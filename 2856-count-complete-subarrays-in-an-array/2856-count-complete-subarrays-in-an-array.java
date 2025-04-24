class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set1 = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            set1.add(i);
        }
        int count = set1.size();
        int left = 0, right = 0;
        int ans = 0;
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() == count){
                ans += nums.length - right;
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0)map.remove(nums[left]);
                left++;
            }
            right++;
        }
        return ans;
    }
}