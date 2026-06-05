class Solution {
    public int minLengthAfterRemovals(String s) {
        int n = s.length() ;
        int countA = 0 ;
        int countB = 0 ;
        for(int i=0 ; i<n ; i++) {
            if(s.charAt(i) == 'a') {
                countA++;
            }
            else {
                countB++;
            }
        }
        return Math.abs(countA-countB);
    }
}