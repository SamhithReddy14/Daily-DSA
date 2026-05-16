class Solution {
    public int findMin(int[] nums) {
        int n = nums.length ;
        int low = 0 ;
        int high = n-1 ;
        int ans = Integer.MAX_VALUE ;
        while(low <= high) {
            int mid = low+(high-low) / 2 ;
            if (nums[mid] >= nums[low]) {
                ans = Math.min(ans , nums[low]) ;
                low++;
            }
            else {
                ans = Math.min(ans , nums[mid]) ;
                high-- ;
            }
        }
        return ans ;
    }
}