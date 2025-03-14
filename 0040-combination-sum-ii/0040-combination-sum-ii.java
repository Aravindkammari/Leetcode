class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> mainList = new ArrayList<>();
        helper(mainList, new ArrayList(){}, candidates, target, 0);
        return mainList;
    }
    void helper(List<List<Integer>> mainList, ArrayList<Integer> list, int[] c, int target, int i){
        if(target < 0)return;
        if(target == 0){
            mainList.add(new ArrayList<>(list));
            return;
        }
        for(int j = i; j < c.length; j++){
            if(j > i && c[j] == c[j-1])continue;
            list.add(c[j]);
            helper(mainList, list, c, target-c[j], j+1);
            list.remove(list.size()-1);
        }
    }
}