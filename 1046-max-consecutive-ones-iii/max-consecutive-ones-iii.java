class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length ;
        int left = 0 ;
        int count = 0 ;
        int max = 0 ;
        for(int i = 0 ; i<n ; i++)  {
            if(nums[i] == 0) {
                count++ ;
            }
            if(count > k) {
                if(nums[left] == 0) {
                    count--;
                }
                left++ ;
            }
            max = Math.max(max , i-left+1) ;
        }
        return max ;

    }
}