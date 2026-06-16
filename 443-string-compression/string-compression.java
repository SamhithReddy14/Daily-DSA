class Solution {
    public int compress(char[] chars) {
        int n = chars.length ;
        StringBuilder sb = new StringBuilder() ;
        HashMap<Character,Integer> map = new HashMap<>() ;
        for(char ch : chars) {
            map.put(ch,map.getOrDefault(ch,0)+1) ;
        }
        char c = chars[0] ;
        int count = 1 ;
        //sb.append(c);
        for(int i=1 ; i<n ; i++) {
            if(chars[i] == c) {
                count++ ;
            }
            else {
                sb.append(c) ;
                if(count != 1) {
                    sb.append(count);
                }
                count = 1 ;
                c = chars[i] ;
            }
        }
         sb.append(c);
        if (count > 1) {
            sb.append(count);
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length() ;
    }
}