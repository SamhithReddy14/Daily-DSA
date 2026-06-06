class Solution {
    public int[] leftRightDifference(int[] nums) {
        int [] prefixsum = new int[nums.length+1] ;
        prefixsum[0] = 0 ;
        int[] ans = new int[nums.length] ;
        for (int i = 1; i <= nums.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int left= prefixsum[i];
            int right=prefixsum[nums.length]-prefixsum[i+1];
            ans[i]=Math.abs(right-left);
            
        }
        return  ans ;
    }
}