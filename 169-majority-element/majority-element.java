class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums.length/2 ;
        int ans = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for(int i=0 ; i<nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1) ;
            if(map.get(nums[i]) > maj) {
                ans = nums[i] ;
                break ;
            }
        }
        return ans ;
    }
}