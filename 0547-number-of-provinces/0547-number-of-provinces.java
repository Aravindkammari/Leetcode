class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        for(int i = 1; i <=n; i++){
            if(!visited[i]){
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }
    void dfs(int[][] mat, int i, boolean[] visited){
        visited[i] = true;
        for(int j = 0; j < mat[i - 1].length; j++){
            if(!visited[j+1] && mat[i - 1][j] == 1){
                dfs(mat, j + 1, visited);
            }
        }
    }
}