class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(mainList, list, nums, 0);
        return mainList;
    }
    void helper(List<List<Integer>> mainList, List<Integer> list, int[] nums, int i){
        if(i == nums.length){
            if(!mainList.contains(list))mainList.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(mainList, list, nums, i + 1);
        list.remove(list.size() - 1);
        helper(mainList, list, nums, i + 1);
    }
}