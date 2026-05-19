class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length ;
        int m = nums2.length ;
        HashSet<Integer> set = new HashSet<>() ;
        for(int i=0 ; i<n ; i++) {
            set.add(nums1[i]) ;
        }
        //int ans = -1 ;
        for(int i=0 ; i<m ; i++) {
            if(set.contains(nums2[i])) {
                return nums2[i];
            }
        }
        return -1;
    }
}