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
    public ListNode reverseList(ListNode head) {
        // three pointers
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null){
            next = curr.next; // set next to store the link of current element, this avoids losing reference as we move through the list
            curr.next = prev; // current element's next link becomes the previous, generating the reversal, since we start from the top
            prev = curr; // new previous element will now be our current element, for use in our next iteration
            curr = next;  // using the reference stored at the beginning, assign current with reference of the rest of the list
        }
        
        return prev; // return new list
    }
}