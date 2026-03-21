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
    public ListNode doubleIt(ListNode head) {
        if (head.val >= 5)
            head = new ListNode(0, head);
        dbl(head);
        return head;
    }

    private int dbl(ListNode head) {
        if (head == null)
            return 0;
        int carry = dbl(head.next);
        head.val *= 2;
        head.val += carry;
        carry = head.val / 10;
        head.val %= 10;
        return carry;
    }
}