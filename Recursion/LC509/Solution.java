/*
 * Another recursive problem; these ones are better understood by drawings to really understand what
 * is happening
*/
class Solution {
    public int fib(int n) {
        return F(n);
    }
    
    public int F(int n){
        return recF(n);
    }
    

    /*
     * The general rule for Fibonacci numbers is that:
     * F(n) = F(n-1) + F(n-2)
     * With the base cases of F(0) = 0 and F(1) = 1
    */
    public int recF(int n){
        // if n is 0 or 1, we can just return n since those are our base cases, outlined above
        if(n <= 1) 
            return n;
        
        // Else we keep going down our tree, following the general rule
        return recF(n-1) + recF(n-2);
    }
}