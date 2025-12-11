class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] rowMin = new int[n + 1];
        int[] rowMax = new int[n + 1];
        int[] colMin = new int[n + 1];
        int[] colMax = new int[n + 1];
        Arrays.fill(rowMin, n + 1);
        Arrays.fill(colMin, n + 1);
        int count = 0;
        for(int[] b : buildings){
            int x = b[0], y = b[1];
            rowMin[y] = Math.min(rowMin[y], x);
            rowMax[y] = Math.max(rowMax[y], x);
            colMin[x] = Math.min(colMin[x], y);
            colMax[x] = Math.max(colMax[x], y);
        }
        for(int[] b : buildings){
            int x = b[0], y = b[1];
            if(x < rowMax[y] && x > rowMin[y] && y < colMax[x] && y > colMin[x])count++;
        }
        return count;
    }
}