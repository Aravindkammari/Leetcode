class Solution {
    List<List<Integer>> mainList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        mainList.add(new ArrayList<Integer>(){});
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            helper(list, i+1, nums);
        }
        return mainList;
    }
    void helper(List<Integer> list, int i, int[] nums){
        if(i == nums.length){
            mainList.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(list, i+1, nums);
        list.remove(list.size()-1);
        helper(list, i+1, nums);
        return;
    }
}