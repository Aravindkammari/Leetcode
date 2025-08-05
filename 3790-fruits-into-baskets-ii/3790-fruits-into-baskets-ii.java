class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int ans = 0, n = f.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(f[i] <= b[j] && b[j] != -1){
                    b[j] = -1;
                    f[i] = -1;
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(f[i] != -1)ans++;
        }
        return ans;
    }
}