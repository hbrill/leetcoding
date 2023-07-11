class Solution {
    // Goal is to remove elements, and the return value must be the x elements in the array that are valid. 
    // Removed elements can be replaced with and *invalid* value. See constraints in prompt.
    public int removeElement(int[] nums, int val) { // we're given an array, and a value to remove from it(every instance of this value)
        int ptr = 0;
        int total = nums.length; // read as number of good elements in array (elements that are not equal to val)
        for(int i = 0; i < nums.length; i++){
            // Loop over array, if we encounter the value to remove, we set it to 102 since it is a constraint as per the instructions
            // and we reduce the good elements each time we encounter the value
            if(nums[i] == val){
                nums[i] = 102;
                total--;
                if(nums[ptr] != 102)
                 /* The pointer keeps track of the last index where we had to remove an element.
                    In the next branch we will filling up the indices were an element was removed with those elements that are 
                    valid. Since the LC judge expects to only return the total elements(good elements), we need to make sure
                    those elements find themselves in the first total indices(i.e if total == 5, good elements must be in the
                    first 5 indices of array).
                    If the element at the index the pointer is at has been filled with a good element, and we find an bad
                    element, we move the pointer to the most recent bad element found in this branch.
                 */
                    ptr = i;
            }else if(nums[ptr] == 102){
                // Now, if our pointer is pointing at an index where an bad value previously was, and we still have good
                // elements left in the array, we exchange the position of the good element and the bad element
                nums[ptr] = nums[i];
                nums[i] = 102;
                ptr++;    
            }
        }
        
        return total;
    }
}