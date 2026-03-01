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
    public int pairSum(ListNode head) {
        int n = 0, sum = 0;
        ListNode temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        int[] arr = new int[n / 2];

        temp = head;

        int i = 0;
        while (i < arr.length) {
            arr[i++] = temp.val;
            temp = temp.next;
        }

        while (i > 0) {
            arr[--i] += temp.val;
            sum = Math.max(sum, arr[i]);
            temp = temp.next;
        }

        return sum;
    }
}