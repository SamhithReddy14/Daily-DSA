class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length ;
        for(int i=0 ; i<n ; i++) {
            int x = nums[i]*nums[i] ;
            nums[i] = x ;
        }
        Arrays.sort(nums) ;
        return nums ;
    }
}