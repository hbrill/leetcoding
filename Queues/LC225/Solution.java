class MyStack {
    // Use two queues to handle removal of top stack element
    Queue<Integer> queueOne;
    Queue<Integer> queueTwo;
    int numElements;
    int topElement;
    public MyStack() {
        queueOne = new LinkedList<Integer>();
        queueTwo = new LinkedList<Integer>();
        numElements = 0;
    }
    
    // Simply add the element to the queue and update topElement with the new one added
    public void push(int x) {
        queueOne.add(x);
        numElements++;
        topElement = x;
    }
    
    public int pop() {
        int i = 0;
        int prevTop = 0;
        /*
         * On a queue, the most recently added element goes to the back. So we will utilize our queueTwo
         * by adding all elements but the last one to it. Once left with the last added element, we remove
         * it from the queue, and assign the return value of this operation to prevTop, as a stack's pop
         * method needs to return the removed element. Additionally, we want to assign the topElement var
         * with the value of the last element we will add to queueTwo.
         */
        if(!queueOne.isEmpty()){
            // The last element of the queue is == numElements -1. The second to last, which will be out
            // new topElement after this method is done operating, is numElements-2
            while(i <= numElements - 2){
                if(i == numElements - 2)
                    topElement = queueOne.peek();
                
                queueTwo.add(queueOne.remove());
                i++;
            }
            prevTop = queueOne.remove();
        }
        
        queueOne = queueTwo; // and finally, reassign queueOne with queueTwo, i.e our new queue/stack, to do it all again
        numElements--;
        return prevTop;
    }
    
    public int top() {
        return topElement;
    }
    
    public boolean empty() {
        return numElements == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */