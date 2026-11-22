class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        boolean found = false ;
        for(int i=0 ; i<n ; i++) {
            if(found){
                if(s.charAt(i) == 'a') {
                    return false ;
                }
            }
            if(s.charAt(i) == 'b') {
                found = true;
            }
        }
        return true ;
    }
}