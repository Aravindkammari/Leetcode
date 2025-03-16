class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] state = new boolean[nums.length];
        helper(ans, new ArrayList(){}, nums, 0, state);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, int i, boolean[] state){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0; j < nums.length; j++){
            if(!state[j]){
                state[j] = true;
                list.add(nums[j]);
                helper(ans, list, nums, j+1, state);
                list.remove(list.size()-1);
                state[j] = false;
            }
        }
    }
}