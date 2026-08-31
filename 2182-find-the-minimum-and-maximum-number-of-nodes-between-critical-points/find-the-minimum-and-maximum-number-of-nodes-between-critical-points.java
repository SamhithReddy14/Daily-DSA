class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() <= 2) return new int[]{-1, -1};
        ArrayList<Integer> criticalpoints = new ArrayList<>();
        for (int i = 1; i < list.size() - 1; i++) {
            int prev = list.get(i - 1);
            int curr = list.get(i);
            int next = list.get(i + 1);
            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                criticalpoints.add(i);
            }
        }
        if (criticalpoints.size() < 2) return new int[]{-1, -1};
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < criticalpoints.size(); i++) {
            minDistance = Math.min(minDistance, criticalpoints.get(i) - criticalpoints.get(i - 1));
        }
        int maxDistance = criticalpoints.get(criticalpoints.size() - 1) - criticalpoints.get(0);
        return new int[]{minDistance, maxDistance};
    }
}