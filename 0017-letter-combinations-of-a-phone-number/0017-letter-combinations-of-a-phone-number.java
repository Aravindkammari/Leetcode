class Solution {
    String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)return ans;
        StringBuilder str = new StringBuilder();
        helper(ans, digits, 0, str);
        return ans;
    }
    void helper(List<String> ans, String digits, int i, StringBuilder str){
        if(i == digits.length()){
            ans.add(str.toString());
            return;
        }
        String letters = keys[digits.charAt(i) - '0'];
        for(char ch : letters.toCharArray()){
            str.append(ch);
            helper(ans, digits, i+1, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}