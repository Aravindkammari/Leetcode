class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        q.offer(new int[]{sr, sc});
        int initialColour = image[sr][sc];
        if(initialColour == color)return image;
        image[sr][sc] = color; 
        while(!q.isEmpty()){
            int k = q.size();
            for(int i = 0; i < k; i++){
                int[] axes = q.poll();
                int x = axes[0];
                int y = axes[1];
                int[][] neighbours = {{x-1, y}, {x, y-1}, {x+1, y}, {x, y+1}};
                for(int[] neighbour : neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || image[nr][nc] != initialColour)continue;
                    q.offer(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}