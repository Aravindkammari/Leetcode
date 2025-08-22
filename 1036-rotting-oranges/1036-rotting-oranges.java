class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }
        int time = 0;
        if(fresh == 0)return 0;
        while(!q.isEmpty()){
            int k = q.size();
            for(int i = 0; i < k; i++){
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];
                int[][] neighbours = {{x-1, y}, {x, y-1}, {x+1, y}, {x, y+1}};
                for(int[] neighbour : neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1)continue;
                    grid[nr][nc] = 2;
                    q.offer(new int[] {nr, nc});
                    fresh--;
                }
            }
            time++;
            if(fresh == 0)break;
        }
        return (fresh == 0) ? time : -1;
    }
}