class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);
            if(ch == 'U'){
                x -= 1;
            }else if(ch == 'D'){
                x+=1;
            }else if(ch == 'R'){
                y+=1;
            }else{
                y-=1;
            }
        }
        return x == 0 && y == 0;
    }
}