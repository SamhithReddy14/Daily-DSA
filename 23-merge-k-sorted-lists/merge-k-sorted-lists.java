class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                pq.offer(curr.val);
                curr = curr.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        while (!pq.isEmpty()) {
            ans.next = new ListNode(pq.poll());
            ans = ans.next;
        }
        return dummy.next;
    }
}