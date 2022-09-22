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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(0);
        ListNode ptr = mergedList; 
        
        // Only iterate while both are not null. The lesser number gets added to the list 
        // pointing to our mergedList linked list, and we only move to the next of the list 
        // that has the lesser number of the two 
        while(list1 != null && list2 != null){
            if(list2.val < list1.val){
                ptr.next = list2; // set pointer to the list node with lesser value
                list2 = list2.next;
            }else{
                ptr.next = list1;
                list1 = list1.next;
            }
            ptr = ptr.next; // move pointer to our newly added node so that we can set it to point
            // to next node in next iteration 
        }
        
        // Since we only loop while both lists are NOT null, if one of them is null but the other
        // isn't we will add remaining of the one that isn't to ptr,
        if(list1 == null && list2 != null){
            ptr.next = list2;
            list2 = list2.next;
        }else if(list2 == null && list1 != null){
            ptr.next = list1;
            list1 = list1.next;
        }
        
        // return next node of mergedList, since as of now mergedList is pointing to 0
        return mergedList.next;
    }
}