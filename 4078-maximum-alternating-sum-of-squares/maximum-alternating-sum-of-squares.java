class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length ;
        for(int i=0 ; i<n ; i++) {
            if(nums[i] < 0) {
                nums[i] *= -1 ;
            }
        }
        Arrays.sort(nums) ;
        int count = 0 ;
        if(n%2 == 0) {
            count = n/2 ;
        }
        else {
            count = (n/2)+1 ;
        }
        long sum = 0 ;
        for(int i=n-1 ; i>=0 ; i--) {
            if(count>0) {
                sum += nums[i]*nums[i];
                count--;
            }
            else {
                sum -= nums[i]*nums[i];
            }
        }
        return sum ;
    }
}