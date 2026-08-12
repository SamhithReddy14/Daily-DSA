class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length ;
        int left = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int max = 1 ;
        for(int i=0 ; i<n ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i]) > k) {
                map.put(nums[left],map.getOrDefault(nums[left],0)-1) ;
                left++;
            }
            max = Math.max(max,i-left+1) ;
        }
        return max ;
    }
}