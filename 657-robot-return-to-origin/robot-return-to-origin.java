class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length() ;
        int countU = 0 ;
        int countD = 0 ;
        int countL = 0 ;
        int countR = 0 ;
        for(int i=0 ; i<n ; i++) {
            if(moves.charAt(i) == 'U') countU++ ;
            if(moves.charAt(i) == 'D') countD++ ;
            if(moves.charAt(i) == 'L') countL++ ;
            if(moves.charAt(i) == 'R') countR++ ;
        }
        if(countU == countD  &&  countL == countR) return true ;
        return false ;
    }
}