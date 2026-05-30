class Solution {
    public int passwordStrength(String password) {
        int n = password.length() ;
        int count = 0 ;
        HashSet<Character> set = new HashSet<>() ;
        for(int i=0 ; i<n ; i++) {
            if(password.charAt(i)>='a'  && password.charAt(i)<='z') {
                if(!set.contains(password.charAt(i))) {
                    set.add(password.charAt(i)) ;
                    count += 1 ;
                }
            }
            if(password.charAt(i)>='A'  && password.charAt(i)<='Z') {
                if(!set.contains(password.charAt(i))) {
                    set.add(password.charAt(i)) ;
                    count += 2 ;
                }
            }
            if(password.charAt(i)>='0'  && password.charAt(i)<='9') {
                if(!set.contains(password.charAt(i))) {
                    set.add(password.charAt(i)) ;
                    count += 3 ;
                }
            }
            else {
                if(!set.contains(password.charAt(i))) {
                    set.add(password.charAt(i)) ;
                    count += 5 ;
                }
            }
        }
        return count ;
    }
}