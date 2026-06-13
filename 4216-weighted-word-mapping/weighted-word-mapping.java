class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length ;
        StringBuilder sb = new StringBuilder() ;
        for(int i=0 ; i<n ; i++) {
            int sum = 0 ;
            for(int j=0 ; j<words[i].length() ; j++) {
                sum += weights[words[i].charAt(j)-'a'];
            }
            int mod = sum % 26 ;
            char c = (char)('z'-mod) ;
            sb.append(c);
        }
        return sb.toString() ;
    }
}