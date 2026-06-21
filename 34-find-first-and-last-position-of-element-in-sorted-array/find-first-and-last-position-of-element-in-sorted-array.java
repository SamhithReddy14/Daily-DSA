class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int idx1 = -1;
        int idx2 = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                idx1 = i;
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == target) {
                idx2 = i;
                break;
            }
        }

        return new int[]{idx1, idx2};
    }
}
