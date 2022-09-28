/*
 * A doubly linked list with a previous and next links. Supports:
 * get(val) -> get element at list index val
 * addAtHead(val) and addAtTail(val) -> self-explanatory
 * addAtIndex(i, val) -> adds BEFORE passed index. If i == length of list add at tail
 * deleteAtIndex(i) -> self-explanatory
 */

package LC707;

class MyLinkedList {
    MyLinkedList prev, next, head, tail;
    int nodeIndex, val;
    public MyLinkedList() {
        nodeIndex = -1; // as all things programming, list is 0-indexed 
        prev = null;
        next = null;
    }
    
    public int get(int index) {
        int returnVal;
        // if list empty or index greater than list last element's index return -1
        if (head == null || index > nodeIndex)
            returnVal = -1;
        else if (index == nodeIndex) // if index is same as index of last element, return tail
            returnVal = tail.val;
        else {
            MyLinkedList curr = head;
            int i = -1;
            while (i < index - 1) { // else loop until we get to the element at given index
                curr = curr.next;
                i++;
            }
            returnVal = curr.val;
        }

        return returnVal;
    }
    
    public void addAtHead (int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head; 
            head.prev = newNode;
            head = newNode;
        }
        
        nodeIndex++;
    }
    
    public void addAtTail (int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        if (tail == null) { 
            // if tail is null, we're empty. The first element to be on the list will always be the head and tail until another one is added
            addAtHead(val);
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            nodeIndex++;
        }
    }
    
    public void addAtIndex (int index, int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        if (index <= 0) 
            addAtHead(val);
        else if (nodeIndex + 1 == index) // nodeIndex + 1 = length of the list
            addAtTail(val);
        else if (nodeIndex == index) {
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
            nodeIndex++;
        } else if(!(index > nodeIndex)) { // if index greater than last element's index, don't add
            if(index == 1){
                newNode.next = head.next;
                newNode.prev = head;
                head.next.prev = newNode;
                head.next = newNode;
                nodeIndex++;
            } else {
                MyLinkedList curr = head;
                int i = -1;
                while(i < index - 1){
                    curr = curr.next;
                    i++;
                }
                newNode.prev = curr.prev;
                newNode.next = curr;
                curr.prev.next = newNode;
                curr.prev = newNode;
                nodeIndex++;
            }
             
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index == 0){
            head = head.next;
            nodeIndex--;
            if(nodeIndex == -1){
                head = null;
                tail = null;
            }
        }else if(index == nodeIndex){
            tail = tail.prev;
            nodeIndex--;
        }else if(!(index > nodeIndex)){
            MyLinkedList curr = head;
            int i = -1;
            while(i < index - 1){
                curr = curr.next;
                i++;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            nodeIndex--;
        }
    }
}
