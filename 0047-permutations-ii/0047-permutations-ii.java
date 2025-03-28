class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        helper(ans, new ArrayList(){}, nums, visited);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0; j < nums.length; j++){
            if(visited[j])continue;
            if (j > 0 && nums[j] == nums[j - 1] && !visited[j - 1]) continue;
            visited[j] = true;
            list.add(nums[j]);
            helper(ans, list, nums, visited);
            list.remove(list.size()-1);
            visited[j] = false;
        }
    }
}