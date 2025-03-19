class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)fresh++;
                else if(grid[i][j] == 2) q.offer(new int[] {i, j});
            }
        }
        if(fresh == 0)return 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                int[][] neighbours = {{x-1, y}, {x, y-1}, {x+1, y}, {x, y+1}};
                for(int[] neighbour : neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1)continue;
                    q.offer(new int[] {nr, nc});
                    grid[nr][nc] = 2;
                }
            }
            fresh -= q.size();
            time++;
            if(fresh == 0)break;
        }
        return fresh == 0 ? time : -1;
    }
}