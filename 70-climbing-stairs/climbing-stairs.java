class Solution {
    public int climbStairs(int n) {
        if(n<=3) return n;
        int prev = 3 ;
        int prev1 = 2 ;
        int curr = 0 ;
        for(int i=3 ; i<n ; i++) {
            curr = prev + prev1 ;
            prev1 = prev ;
            prev = curr ;
        }
        return curr;
    }
}