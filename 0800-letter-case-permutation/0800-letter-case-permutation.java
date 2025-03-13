class Solution {
    List<String> list = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        StringBuilder str = new StringBuilder();
        helper(s, str, 0);
        return list;
    }
    void helper(String s, StringBuilder str, int i){
        if(i == s.length()){
            list.add(str.toString());
            return;
        }
        if(Character.isLetter(s.charAt(i))){
            str.append(Character.toUpperCase(s.charAt(i)));
            helper(s, str, i+1);
            str.deleteCharAt(str.length()-1);
            str.append(Character.toLowerCase(s.charAt(i)));
            helper(s, str, i+1);
            str.deleteCharAt(str.length()-1);
        }else{
            str.append(s.charAt(i));
            helper(s, str, i+1);
            str.deleteCharAt(str.length()-1);
        }
    }
}