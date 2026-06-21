class Solution {
    public int maxDistance(String moves) {
        int n = moves.length() ;
        int x = 0 ;
        int y = 0 ;
        int count = 0 ;
        for(int i=0 ; i<n ; i++) {
            if(moves.charAt(i) == 'U' ) y++ ;
            else if(moves.charAt(i) == 'D') y--;
            else if(moves.charAt(i) == 'L') x++ ;
            else if(moves.charAt(i) == 'R') x-- ;
            else {
                count++;
            }
        }
        if(x>0) {
            x += count ;
        }
        else {
            x -= count ;
        }
        return Math.abs(x) + Math.abs(y) ;
    }
}