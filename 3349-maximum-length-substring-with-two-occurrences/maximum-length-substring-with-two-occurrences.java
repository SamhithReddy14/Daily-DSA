class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length() ;
        HashMap<Character,Integer> map = new HashMap<>() ;
        int max = 0 ;
        int left = 0 ;
        for(int i=0 ; i<n ; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1) ;
            while(map.get(s.charAt(i)) > 2) {
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1) ;
                left++;
            }
            max = Math.max(max,i-left+1) ;
        }
        return max ;
    }
}