class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3)return false;
        boolean isVowel = false;
        boolean isConsonant = false;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!Character.isLetter(ch) && !Character.isDigit(ch))return false;
            if(vowel(ch))isVowel = true;
            else if(Character.isLetter(ch))isConsonant = true;
        }
        return isVowel && isConsonant;
    }
    boolean vowel(char c){
        char ch = Character.toLowerCase(c);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u')return true;
        return false;
    }
}