class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length ;
        int max = 0 ;
        int curr = 0;
        for(int i=0 ; i<n ; i++) {
            curr += gain[i] ;
            max = Math.max(curr,max);
        }
        return max ;
    }
}