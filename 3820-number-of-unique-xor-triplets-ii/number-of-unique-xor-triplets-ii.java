class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length ;
        HashSet<Integer> set = new HashSet<>() ;
        for(int i=0 ; i<n ; i++) {
            int xor = nums[i] ;
            for(int j=i ; j<n ; j++) {
                set.add(xor^nums[j]) ;
            }
        }
        HashSet<Integer> ans = new HashSet<>() ;
        for(int x : set) {
            for(int i=0 ; i<n ; i++) {
                ans.add(x^nums[i]) ;
            }
        }
        return ans.size() ;
    }
}