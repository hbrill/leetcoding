class Page {
    Page prev, next;
    String url;
    
    public Page(String url){
        this.url = url;
    }
}

class BrowserHistory {
    Page back, forward, first, last, current;
    int backSteps, forwardSteps = 0;
    public BrowserHistory(String homepage) {
        Page newPage = new Page(homepage);
        first = newPage;
        last = first;
        current = last;
    }
    
    public void visit(String url) {
        Page newNode = new Page(url);
        if(current != last)
            forwardSteps = 0;
        
        newNode.prev = current;
        current.next = newNode;
        last = newNode;
        current = last;
        backSteps++;
        
    }
    
    public String back(int steps) {
        if(backSteps <=  steps){
            forwardSteps += backSteps;
            backSteps -= backSteps;
            current = first;
        }else{
            Page ptr = current;
            int i = 0;
            while(i < steps){
                ptr = ptr.prev;
                backSteps--;
                forwardSteps++;
                i++;
            }
            current = ptr;
        }
         return current.url;
    }
    
    public String forward(int steps) {
        if(forwardSteps <= steps){
            backSteps += forwardSteps;
            forwardSteps -= forwardSteps;
            current = last;
        }else{
            Page ptr = current;
            int i = 0;
            while(i < steps){
                ptr = ptr.next;
                forwardSteps--;
                backSteps++;
                i++;
            }
            current = ptr;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */