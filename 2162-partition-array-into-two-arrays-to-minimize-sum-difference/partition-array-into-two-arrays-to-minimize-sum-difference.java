class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);
        int total = 0;
        for (int x : nums) total += x;
        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }
        int limit = 1 << n;
        for (int mask = 0; mask < limit; mask++) {
            int count = 0;
            int lsum = 0;
            int rsum = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    count++;
                    lsum += left[j];
                    rsum += right[j];
                }
            }
            leftSums[count].add(lsum);
            rightSums[count].add(rsum);
        }
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k <= n; k++) {
            List<Integer> L = leftSums[k];
            List<Integer> R = rightSums[n - k];
            for (int lsum : L) {
                double target = total / 2.0 - lsum;
                int pos = Collections.binarySearch(
                    R, (int)Math.ceil(target)
                );
                if (pos < 0) pos = -pos - 1;
                if (pos < R.size()) {
                    int selected = lsum + R.get(pos);
                    ans = Math.min(ans,
                            Math.abs(total - 2 * selected));
                }
                if (pos > 0) {
                    int selected = lsum + R.get(pos - 1);
                    ans = Math.min(ans,
                            Math.abs(total - 2 * selected));
                }
            }
        }
        return ans;
    }
}