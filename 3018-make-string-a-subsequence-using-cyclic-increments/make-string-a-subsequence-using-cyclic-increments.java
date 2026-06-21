class Solution {
    public static char incrementChar(char c) {
        return (char) ('a' + (c - 'a' + 1) % 26);
    }   
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length() ;
        int m = str2.length() ;
        int i=0 ;
        int j=0 ;
        while(i<n && j<m) {
            if(str1.charAt(i) == str2.charAt(j) ) {
                i++ ;
                j++ ;
            }
            else if(incrementChar(str1.charAt(i)) == str2.charAt(j)) {
                i++ ;
                j++ ;
            }
            else {
                i++;
            }

            //if(i == n-1) return false;
        }
        return j == m ;
    }
}