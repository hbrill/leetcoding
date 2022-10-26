class Solution {
    public int climbStairs(int n) {
        
        // Base cases. No need to compute anything.
        if((n == 1) || (n == 2))
            return n;
        
        int one, two;
        one = two = 1;
        for(int i = 0; i < n - 2; i++){
            int temp = one;
            one = one + two;
            two = temp;
        }
        
        return one+two;
    }
}