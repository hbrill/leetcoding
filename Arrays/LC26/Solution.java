class Solution {
    // The goal is to replace all duplicate elements in the array with an invalid value. See constraints.
    // Assumming that elements are SORTED this will work
    public int removeDuplicates(int[] nums) {
        int non_dup = 0;
        for(int i = 1; i < nums.length; i++){
            /* We start looping at second index. If element at index is not equals to the element at the non_dup index,
            we move this pointer one up and replace the value at this index with this value. 
            Keep in mind this works because we have input in the format [0,0,1,2,2,3,4,4,5], and since repeated elements
            are consequents, we can just move the pointer up and replace any instance of the element after the first one
            with the non-repeated elements. */
            
            if(nums[i] != nums[non_dup]){
                non_dup++;
                nums[non_dup] = nums[i];
            }
        }
        return non_dup+1;
    }
}