class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length ;
        int sum = 0 ;
        for(int x : nums) {
            sum += x ;
        }if(sum %2 != 0 ) return false ;
        int half = sum/2 ;
        boolean dp[] = new boolean[half+1] ;
        dp[0] = true ;
        for(int i=0 ; i<n ; i++) {
            for(int j=half ; j>=nums[i] ; j--) {
                dp[j] = dp[j] || dp[j-nums[i]] ;
                if(dp[half]) return true ;
            }
        }
        return false ;
    }
}