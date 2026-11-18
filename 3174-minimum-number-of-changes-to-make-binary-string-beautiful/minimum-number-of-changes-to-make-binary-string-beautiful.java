class Solution {
    public int minChanges(String s) {
        int n = s.length() ;
        int substring = n/2 ;
        int count = 0 ;
        for(int i=0 ; i<n-1 ; i+=2) {
            if(s.charAt(i) == '0' && s.charAt(i+1) == '1') {
                count++ ;
            }
            if(s.charAt(i) == '1' && s.charAt(i+1) == '0') {
                count++ ;
            }
            if(s.charAt(i) == '0' && s.charAt(i+1) == '0') {
                continue ;
            }
            if(s.charAt(i) == '1' && s.charAt(i+1) == '1') {
                continue;
            }
        }
        return count ;
    }
}