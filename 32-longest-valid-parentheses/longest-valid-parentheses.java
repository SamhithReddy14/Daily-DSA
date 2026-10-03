class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length() ;
        int max = 0 ;
        Stack<Integer> st = new Stack<>() ;
        st.push(-1);
        for(int i=0 ; i<n ; i++) {
            char c = s.charAt(i) ;
            if(c == '(') {
                st.push(i);
            }
            else {
                st.pop(); 
                if(st.isEmpty()) {
                    st.push(i);
                }
                else {
                    int curr = i-st.peek() ;
                    max = Math.max(max,curr) ;
                }
            }

        }
        return max ;
    }
}