class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int left = -1;
        int right = -1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                right = i;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                left = i;
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }
}