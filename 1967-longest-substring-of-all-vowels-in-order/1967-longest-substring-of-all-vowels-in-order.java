class Solution {
    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        int count = 1;
        int chars = 1;
        int max = 0;
        for(int right = 1; right < n; right++){
            if(word.charAt(right) >= word.charAt(right - 1)){
                if(word.charAt(right) != word.charAt(right - 1)){
                    chars++;
                }
                count++;
            }else{
                if(chars == 5){
                    max = Math.max(count, max);
                }
                count=1;
                chars=1;
            }
        }
        if(chars == 5)max = Math.max(max, count);
        return max;
    }
}