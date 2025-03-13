class Solution {
    List<List<Integer>> mainList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, list);
        return mainList;
    }
    void helper(int[] nums, int i, List<Integer> list){
        if(i == nums.length){
            if(!mainList.contains(list)){
                mainList.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[i]);
        helper(nums, i+1, list);
        list.remove(list.size()-1);
        helper(nums, i+1, list);
    }
}