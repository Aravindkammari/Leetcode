class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> mainList = new ArrayList<>();
        helper(new ArrayList(){}, mainList, candidates, target, 0);
        return mainList;
    }
    void helper(List<Integer> list, List<List<Integer>> mainList, int[] c, int target, int i){
        
        if(target < 0)return;
        if(target == 0){
            mainList.add(new ArrayList<>(list));
            return;
        }
        if(i >= c.length)return;
        list.add(c[i]);
        helper(list, mainList, c, target-c[i], i);
        list.remove(list.size()-1);
        helper(list, mainList, c, target, i+1);
    }
}