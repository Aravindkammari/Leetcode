class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> mainList = new ArrayList<>();
        helper(mainList, new ArrayList<>(), k, n, 1);
        return mainList;
    }
    void helper(List<List<Integer>> mainList, List<Integer> list, int k, int n, int i){
        if(n < 0)return;
        if(list.size() == k && n == 0){
            mainList.add(new ArrayList<>(list));
            return;
        }
        if(i > 9 || k < list.size())return;
        list.add(i);
        helper(mainList, list, k, n - i, i + 1);
        list.remove(list.size() - 1);
        helper(mainList, list, k, n, i + 1);
    }
}