class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0 ;
        long i = 1000 ;
        long commas = 1 ;
        long ans = 0 ;
        while(i <= n) {
            long j = Math.min(n,i*1000-1);
            long count = j-i+1 ;
            ans += count*commas ;
            i *= 1000 ;
            commas++ ;
        }
        return ans ;
    }
}