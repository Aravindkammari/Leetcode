class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(ans, path, s, 0);
        return ans;
    }
    void helper(List<List<String>> ans, List<String> path, String s, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                helper(ans, path, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int low, int high){
        while(low <= high){
            if(s.charAt(low) != s.charAt(high))return false;
            low++;
            high--;
        }
        return true;
    }
}