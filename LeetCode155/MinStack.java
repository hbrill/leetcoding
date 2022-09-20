class MinStack {
    ArrayList<Integer> stack; 
    ArrayList<Integer> minStack; // to keep track of all smaller elements
    int top;
    int minIndex = -1; // index of current smallest element
    
    public MinStack() {
        stack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
        top = -1;
    }
    
    public void push(int val) {
        stack.add(val);
        top++;
        
        // This seems redundant but avoids checking on an empty stack and
        // generating a stack overflow exception
        if(minStack.size() < 1){
            minStack.add(val);
            minIndex++;
        }else if(val < minStack.get(minIndex) || val == minStack.get(minIndex)){
            // this condition checks and adds a value to minStack even if an
            // element of the same value is on the list. In this case, we set
            // the minimum to be the most recently added of the twi
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