class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        if (source[0] == target[0] && source[1] == target[1]) {
            return 0;
        }
        int sum1 = source[0] + source[1];
        int sum2 = target[0] + target[1];
        int diff1 = source[0] - source[1];
        int diff2 = target[0] - target[1];
        if (sum1 == sum2 || diff1 == diff2) {
            return 1;
        }
        if ((sum1 % 2) == (sum2 % 2)) {
            return 2;
        }
        return -1;
    }
}