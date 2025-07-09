class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(mainList, list, candidates, target, 0);
        return mainList;
    }
    void helper(List<List<Integer>> mainList, List<Integer> list, int[] c, int target, int idx){
        if(target == 0){
            Collections.sort(list);
            if(!mainList.contains(list))mainList.add(new ArrayList<>(list));
            return;
        }
        if(target < 0)return;
        for(int i = idx; i < c.length; i++){
            list.add(c[i]);
            helper(mainList, list, c, target - c[i], i);
            list.remove(list.size() - 1);
        }
    }
}