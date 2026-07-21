class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length ;
        int k = 0 ;
        HashSet<Integer> set = new HashSet<>() ;
        for(int i=0 ; i<n ; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]) ;
                nums[k] = nums[i] ;
                k++ ;
            }
        }
        return k ;
    }
}