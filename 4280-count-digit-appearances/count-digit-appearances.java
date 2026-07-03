class Solution {
    public int noofdigits(int n , int digit ){
        int c = 0 ;
        while(n>0) {
            int rem = n%10 ;
            if(rem == digit) c++ ;
            n /= 10 ;
        }
        return c ;
    }
    public int countDigitOccurrences(int[] nums, int digit) {
        int n = nums.length ;
        int count = 0 ;
        for(int i=0 ; i<n ; i++) {
            count += noofdigits(nums[i],digit) ;
        }
        return count ;
    }
}