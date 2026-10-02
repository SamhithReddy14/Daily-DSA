class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>() ;
        backtrack(0,0,"",n,list);
        return list ;
    }
    public void backtrack(int open , int close , String s , int n , List<String> list) {
        if(open == close && (open+close) == 2*n) {
            list.add(s);
            return ;
        }
        if(open < n) {
            backtrack(open+1 , close , s+"(" , n , list) ;
        }
        if(open > close) {
            backtrack(open , close+1 , s+")",n,list) ;
        }
    }
}