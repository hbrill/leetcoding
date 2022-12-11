// A LL Node represents a single page
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
        // when you open a page, that is both the first and last page in your history
        first = newPage;
        last = first;
        current = last;
    }
    
    public void visit(String url) {
        Page newNode = new Page(url);
        // if we visit a page from another page that is not the last, reset all forward steps
        if(current != last)
            forwardSteps = 0;
        
        // new page's previous page will be our current page
        newNode.prev = current;
        current.next = newNode; // current page's next page will be the new one
        last = newNode; // new page becomes the latest visited one
        current = last; // current page also becomes the latest visited one 
        backSteps++; // we can now go back an extra page
        
    }
    
    public String back(int steps) {
        if(backSteps == 0)
            return first.url; // if there are no pages to go back to, then return the first/current page
        else if(backSteps <=  steps){
            // if number of steps to go back is greater than number of pages visited previously, go back as many pages back as possible
            forwardSteps += backSteps; // since we're going all the way back, the number of forward steps is added the number of back steps we took
            backSteps -= backSteps; // backsteps taken are subtracted from the variable, or become 0
            current = first; // our current page is the initia; one
            return first.url;
        }else{
            // else, simply go back as many steps as requested
            Page ptr = current;
            int i = 0;
            while(i < steps){
                ptr = ptr.prev; // point to the current's previous page
                backSteps--; // as we go back, we lose backsteps to take
                forwardSteps++; // and gain forward steps
                i++;
            }
            current = ptr;
            return current.url;
        }
    }
    
    // similar as above, but moving forward instead
    public String forward(int steps) {
        if(forwardSteps == 0)
            return current.url;
        else if(forwardSteps <= steps){
            backSteps += forwardSteps;
            forwardSteps -= forwardSteps;
            current = last;
            return last.url;
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
            return current.url;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */