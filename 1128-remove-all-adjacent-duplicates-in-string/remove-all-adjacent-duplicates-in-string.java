class Solution {
    public String removeDuplicates(String s) {
        int n = s.length() ;
        Stack<Character> st = new Stack<>() ;
        for(int i=0 ; i<n ; i++) {
            if(!st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
            }
            else st.push(s.charAt(i)) ;
        }
        StringBuilder sb = new StringBuilder() ;
        for(char ch : st) {
            sb.append(ch);
        }
        return sb.toString() ;
    }
}