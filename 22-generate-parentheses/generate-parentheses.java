class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>() ;
        backtrack(list,"",0,0,n) ;
        return list ;
    }
    public void backtrack(List<String> list , String s , int opencount , int closecount , int n) {
        if(s.length() == 2*n) {
            list.add(s);
            return ;
        }
        if(opencount < n) {
            backtrack(list,s+"(",opencount+1,closecount , n) ;
        }
        if(closecount<opencount) {
            backtrack(list,s+")",opencount , closecount+1,n) ;
        }
    }
}