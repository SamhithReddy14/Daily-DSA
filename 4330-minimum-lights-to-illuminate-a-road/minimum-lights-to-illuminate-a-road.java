class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;

        int[] diff = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (lights[i] != 0) {
                int l = Math.max(0, i - lights[i]);
                int r = Math.min(n - 1, i + lights[i]);

                diff[l]++;
                if (r + 1 < n) diff[r + 1]--;
            }
        }

        boolean[] visible = new boolean[n];

        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            visible[i] = curr > 0;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visible[i]) {
                count++;

                int pos = Math.min(n - 1, i + 1);

                for (int j = Math.max(0, pos - 1);
                     j <= Math.min(n - 1, pos + 1);
                     j++) {
                    visible[j] = true;
                }
            }
        }

        return count;
    }
}