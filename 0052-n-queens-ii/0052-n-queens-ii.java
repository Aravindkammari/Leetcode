class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        char[][] nQueens = new char[n][n];
        for(char[] ch : nQueens){
            Arrays.fill(ch, '.');
        }
        helper(n, nQueens, 0);
        return ans;
    }
    void helper(int n, char[][] nQueens, int row){
        if(row == n){
            ans++;
            return;
        }
        for(int col = 0; col < n; col++){
            if(isSafe(nQueens, n, row, col)){
                nQueens[row][col] = 'Q';
                helper(n, nQueens, row+1);
                nQueens[row][col] = '.';
            }
        }
    }
    boolean isSafe(char[][] nQueens, int n, int row, int col){
        for(int i = 0; i < n; i++){
            if(nQueens[i][col] == 'Q')return false;
        }
        for(int i = row, j = col; i  >= 0 && j >= 0; i--, j--){
            if(nQueens[i][j] == 'Q')return false;
        }
        for(int i = row, j = col; i >= 0 && j < n; i--, j++){
            if(nQueens[i][j] == 'Q')return false;
        }
        return true;
    }
}