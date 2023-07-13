package LC155;

import java.util.ArrayList;

class MinStack {
    // I used to stacks: one for all elements, one to store minimum elements as they get added.
    // The challenge is that when an element gets removed, if it was considered to be the current minimum, how do we get
    // back to what was the previous minimum before the most recent one? Having two stacks solves that
    ArrayList<Integer> stack; 
    ArrayList<Integer> minStack; // to keep track of all smaller elements
    int top;
    int minIndex; // index of current smallest element
    
    public MinStack() {
        stack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
        top = -1;
        minIndex = -1;
    }
    
    public void push(int val) {
        stack.add(val);
        top++;
        
        // if this is the first element in the stack, or if element added is smaller than or equal to current smallest, add to minStack
        if(minStack.size() < 1 || val < minStack.get(minIndex) || val == minStack.get(minIndex)){
            minStack.add(val);
            minIndex++;
        }
    }
    
    public void pop() {
        int prevTop = stack.remove(top);        
        top--;
        if(prevTop == minStack.get(minIndex)){ 
            // remove element from minIndex if top of stack is the minimum and popped 
            minStack.remove(minIndex);
            minIndex--;
        }
    }
    
    public int top() {
        return stack.get(top);
    }
    
    public int getMin() {
        return minStack.get(minIndex);
    }
   
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */