class Solution {
    public long countOfSubstrings(String word, int k) {
        return atleast(k, word) - atleast(k + 1, word);
    }
    public long atleast(int k, String word){
        long count = 0;
        int left = 0;
        int consonants = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < word.length(); right++){
            char ch = word.charAt(right);
            if(isVowel(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            else consonants++;
            while(consonants >= k && map.size() == 5){
                count+=word.length()-right;
                char c = word.charAt(left);
                if(isVowel(c)){
                    map.put(c, map.get(c)-1);
                    if(map.get(c) == 0)map.remove(c);
                }else{
                    consonants--;
                }
                left++;
            }
        }
        return count;
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')return true;
        return false;
    }
}