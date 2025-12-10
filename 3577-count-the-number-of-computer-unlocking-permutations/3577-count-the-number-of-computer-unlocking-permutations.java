class Solution {
    public int countPermutations(int[] complexity) {
        long m = 1000000007;
        long ans = 1;
        for(int i = 1; i < complexity.length; i++){
            if(complexity[0] >= complexity[i])return 0;
            ans *= i;
            ans %= m;
        }
        return (int)ans;
    }
}