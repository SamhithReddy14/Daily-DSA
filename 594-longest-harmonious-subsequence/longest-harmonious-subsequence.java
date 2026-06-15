class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length ;
        Arrays.sort(nums) ;
        int ans = 0 ;
        for(int i=0 ; i<n ; i++) {
            int max = Integer.MIN_VALUE ;
            int min = Integer.MAX_VALUE ;
            for(int j=i ; j<n ; j++) {
                max = Math.max(max,nums[j]) ;
                min = Math.min(min,nums[j]); 
                if(max - min == 1) {
                    ans = Math.max(j-i+1 , ans) ;
                }
            }
        }
        return ans ;
    }
}