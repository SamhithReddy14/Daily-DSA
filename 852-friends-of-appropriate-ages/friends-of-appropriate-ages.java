class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ages[i] <= 14) continue;
            int low = upperBound(ages, (int)(0.5 * ages[i] + 7));
            int high = upperBound(ages, ages[i]);

            ans += high - low - 1;
        }
        return ans;
    }
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}