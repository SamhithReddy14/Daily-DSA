import java.util.Arrays;

class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int largest = nums[n - 1];
        if (largest != n - 1) return false;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        return nums[n - 1] == nums[n - 2];
    }
}