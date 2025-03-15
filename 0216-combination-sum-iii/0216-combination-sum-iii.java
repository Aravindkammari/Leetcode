class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList(){}, 1, k, n);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int i, int k, int n){
        if(n == 0 && k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i > 9)return;
        if(n < 0 || k < 0)return;
        list.add(i);
        helper(ans, list, i+1, k-1, n-i);
        list.remove(list.size()-1);
        helper(ans, list, i+1, k, n);
    }
}