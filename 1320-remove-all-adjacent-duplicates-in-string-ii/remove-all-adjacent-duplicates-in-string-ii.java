class Solution {
    class Pair {
        char ch ;
        int count ;
        public Pair(char ch , int count) {
            this.ch = ch ;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length() ;
        Stack<Pair> st = new Stack<>() ;
        //HashMap<Character,Integer> map = new HashMap<>() ;
        for(int i=0 ; i<n ; i++) {
            if(!st.isEmpty() && st.peek().ch == s.charAt(i) && (st.peek().count+1 == k)) {
                st.pop();
            }
            else if(!st.isEmpty() && st.peek().ch == s.charAt(i)) {
                int val = st.peek().count + 1 ;
                st.pop() ;
                st.push(new Pair(s.charAt(i) , val)) ;
            }
            else {
                st.push(new Pair(s.charAt(i),1)) ;
            }
        }
        StringBuilder sb = new StringBuilder() ;
        for(Pair p  : st) {
            int val = p.count ;
            while(val-->0) {
            sb.append(p.ch);
            }
        }
        return sb.toString() ;
    }
}