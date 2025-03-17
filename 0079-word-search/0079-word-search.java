class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean ans = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                   ans = helper(board, word, m, n, i, j, 0);
                }
                if(ans)return true;
            }
        }
        return ans;
    }
    boolean helper(char[][] b, String s, int m, int n, int i, int j, int index){
        if(s.charAt(index) == b[i][j] && index == s.length()-1)return true;
        if(s.charAt(index) != b[i][j])return false;
        char temp = b[i][j];
        b[i][j] = '@';
        boolean top = false;
        boolean bottom = false;
        boolean right = false;
        boolean left = false;
        if(i > 0){
            top = helper(b, s, m, n, i-1, j, index+1);
        }
        if(i < m-1){
            bottom = helper(b, s, m, n, i+1, j, index+1);
        }
        if(j > 0){
            left = helper(b, s, m, n, i, j-1, index+1);
        }
        if(j < n-1){
            right = helper(b, s, m, n, i, j+1, index+1);
        }
        b[i][j] = temp;
        return top || bottom || right || left;
    }
}