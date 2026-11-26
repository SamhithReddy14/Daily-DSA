class Solution {
    public boolean canAliceWin(int n) {
        int curr = 10 ;
        boolean win = false;
        while(n>=curr) {
            n -= curr;
            if(win) win = false ;
            else win = true ;
            curr--;
        } 
        return win ;
    }
}