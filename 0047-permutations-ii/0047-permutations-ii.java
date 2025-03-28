class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        helper(ans, new ArrayList(){}, nums, visited);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            if(!ans.contains(list)){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int j = 0; j < nums.length; j++){
            if(!visited[j]){
                visited[j] = true;
                list.add(nums[j]);
                helper(ans, list, nums, visited);
                list.remove(list.size()-1);
                visited[j] = false;
            }
        }
    }
}