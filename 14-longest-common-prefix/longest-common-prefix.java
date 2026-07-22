class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length ;
        String s = strs[0] ;
        int len = s.length() ;
        for(int i=1 ; i<n ; i++) {
            String str = strs[i] ;
            while( len > str.length() || !s.equals(str.substring(0,len))) {
                len--;
                if(len == 0) return "";
                s = s.substring(0,len) ;
            }
        }
        return s ;
    }
}