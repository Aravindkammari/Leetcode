class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        char[] ch = new char[2*n];
        ch[0] = '(';
        helper(ch, 1, n-1, n);
        return list;
    }
    void helper(char[] ch, int i, int open, int close){
        if(i == ch.length){
            String str = "";
            for(char c : ch){
                str += c;
            }
            list.add(str);
            return;
        }
        if(open > 0){
            ch[i] = '(';
            helper(ch, i+1, open-1, close);
        }
        if(close > open){
            ch[i] = ')';
            helper(ch, i+1, open, close-1);
        }
    }
}