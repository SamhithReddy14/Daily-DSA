class Solution {
    public long firstdigit(long n) {
        while (n >= 10) {
            n /= 10;
        }
        return n ;
    }
    public long lastdigit(long n) {
        return n%10 ;
    }
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length ;
        int count = 0 ;
        for(int i=0 ; i<n ; i++) {
            long sum = 0 ;
            //StringBuilder sb = new StringBuilder() ;
            for(int j=i ; j<n ; j++) {
                sum += nums[j] ;
                if(firstdigit(sum) == x && lastdigit(sum) == x) count++ ;
            }
        }
        return count ;
    }
}