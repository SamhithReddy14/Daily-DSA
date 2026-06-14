class Solution {
    public static int solve(int i , int j,int nums[]) {
        int dp[] = new int[j-i+1];
        dp[0] = nums[i] ;
        dp[1] = Math.max(dp[0],nums[i+1]);
        for(int a=2 ; a<dp.length ; a++) {
            dp[a] = Math.max(dp[a-2]+nums[i+a] , dp[a-1]) ;
        }
        return dp[dp.length-1] ;
    }
    public int rob(int[] nums) {
        int n = nums.length ;
        if(n == 1) {
            return nums[0];
        }
        if(n == 2) return Math.max(nums[0],nums[1]) ;
        int ans1 = solve(0,n-2,nums);
        int ans2 = solve(1,n-1,nums);
        return Math.max(ans1,ans2);
    }
}