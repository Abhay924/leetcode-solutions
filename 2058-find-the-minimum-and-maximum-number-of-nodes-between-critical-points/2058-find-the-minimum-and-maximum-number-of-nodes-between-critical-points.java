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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prev = -1;
        int minDistance = Integer.MAX_VALUE;
        int index = 1;
        ListNode left = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            if ((curr.val > left.val && curr.val > curr.next.val) ||
                (curr.val < left.val && curr.val < curr.next.val)) {  
                if (first == -1) {
                    first = index;
                }
                if (prev != -1) {
                    minDistance = Math.min(minDistance, index - prev);
                }
                prev = index;
            }
            left = curr;
            curr = curr.next;
            index++;
        }
        if (first == -1 || prev == first) {
            return new int[]{-1, -1};
        }
        return new int[]{minDistance, prev - first};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna