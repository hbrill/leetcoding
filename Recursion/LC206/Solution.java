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


/*
 * This outlines a recursive solution for LC206. The iterative solution has now been moved to the
 * iterReverse method.
 */
import java.util.*;
class Solution {
    public ListNode reverseList(ListNode head) {
        return callerFunction(head, null);
    }
    
    public ListNode iterReverse(ListNode head){
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;     
        }
        
        return prev;
    }
    
    // Outer function that we'll use to call the recursive function
    public ListNode callerFunction(ListNode head, ListNode prev){
        return recReverse(head, prev);
    }

    /*
     * This solution is based outlined with drawings to visualize how it works
     */
    public ListNode recReverse(ListNode node, ListNode prev){
        if(node == null) // when the head of the list is null, we've reached our base case
            return prev;
        
        ListNode hold = node.next;
        node.next = prev;
        return recReverse(hold, node); 
    }
}