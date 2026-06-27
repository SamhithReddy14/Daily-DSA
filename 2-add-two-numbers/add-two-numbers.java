import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }

        BigInteger num1 = new BigInteger(sb1.reverse().toString());
        BigInteger num2 = new BigInteger(sb2.reverse().toString());

        BigInteger sum = num1.add(num2);

        String s = new StringBuilder(sum.toString()).reverse().toString();

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < s.length(); i++) {
            curr.next = new ListNode(s.charAt(i) - '0');
            curr = curr.next;
        }

        return dummy.next;
    }
}