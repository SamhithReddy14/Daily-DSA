class Solution {
    public int gcd(long x , long y) {
        while(y!=0) {
            long t = x%y ;
            x = y ;
            y = t ; 
        }
        return (int)x ;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length ;
        int prefixgcd[] = new int[n] ;
        long max = 0 ;
        for(int i=0 ; i<n ; i++) {
            max = Math.max(max,nums[i]) ;
            prefixgcd[i] = gcd(nums[i],max) ;
        }
        Arrays.sort(prefixgcd) ;
        int i=0 , j=n-1 ;
        long ans = 0 ;
        while(i<j) {
            ans += gcd(prefixgcd[i],prefixgcd[j]) ;
            i++;
            j--;
        }
        return ans ;
    }
}