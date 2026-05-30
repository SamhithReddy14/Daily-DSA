class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length() ;
        long arr[] = new long[n] ;
        for(int i=0 ; i<n ; i++) {
            arr[0] += shifts[i] ;
            if(i+1 < n) arr[i+1] -= shifts[i] ;
        }
        long prefixsum[] = new long[n] ;
        prefixsum[0] = arr[0] ;
        for(int i=1 ; i<n ; i++) {
            prefixsum[i] = arr[i] + prefixsum[i-1] ;
        }
        StringBuilder sb = new StringBuilder() ;
        for(int i=0 ; i<n ; i++) {
            int val = (int) (prefixsum[i]%26) ;
            char ch = s.charAt(i) ;
            int value = ch+val > 122 ? ch+val-123+97 : ch+val ;
            sb.append((char)value);
        }
        return sb.toString() ;
    }
}