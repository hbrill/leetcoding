/*
 * Keep in mind this works because we have input in the format [0,0,1,2,2,3,4,4,5], and since repeated elements
are consequents, we can just move the pointer up and replace any instance of the element after the first one
with the non-repeated elements.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int non_dups = 0; // Tracks last non duplicate index
        // We start at index 1 since the first element at index 0 cannot be a duplicate
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[non_dups]){
                // If the element at the current index is not equals to the element at the last non duplicate index, we move the non duplicate index to point to the next index
                non_dups++;
                // We can assume that the index following the previous non duplicate index is either a) a duplicate element or b) the current element; in either case we reassign it with the current element 
                nums[non_dups] = nums[i];
            }
        }

        // Return only the first k elements which should consist of only the unique elements. Since the variable non_dups is "indexed", add one to represent the actual number of elements
        return non_dups+1; 
    }
}