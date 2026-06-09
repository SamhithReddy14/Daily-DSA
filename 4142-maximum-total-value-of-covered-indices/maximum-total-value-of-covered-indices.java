class Solution {
    public long maxTotal(int[] nums, String s) {
        int n = nums.length;
        long ans = 0;
        long mini = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                ans += nums[i];
                mini = Math.min(mini, nums[i]);
            } else {
                if(i + 1 < n && s.charAt(i + 1) == '1') {
                    ans += nums[i];
                    mini = Math.min(mini, nums[i]);
                    ans -= mini;
                }
                mini = Integer.MAX_VALUE;
            }
        }
        return ans;
    }
}