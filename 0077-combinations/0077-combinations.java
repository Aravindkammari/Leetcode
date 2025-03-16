class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList(){}, 1, n, k);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> list, int i, int n, int k){
        if(k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = i; j <= n; j++){
            list.add(j);
            helper(ans, list, j+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
}