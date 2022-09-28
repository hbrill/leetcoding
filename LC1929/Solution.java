class Solution {
    public int[] getConcatenation(int[] nums) {
        // The goal of concatenating is to join two nums arrays
        int[] ans = new int[nums.length * 2]; // we create a new array double the size of nums so we can concatenate them
        int j = 0; // used to iterate over nums array
        for(int i = 0; i < ans.length; i++){
            // Since nums.length = ans.length/2, we iterate over them with two different indices
            ans[i] = nums[j];
            j++;
            if(j == nums.length) 
                j = 0; // if we get to the last index on nums, but we're halfway through ans array, reset j to 0 so we do one more lap over nums
        }
        return ans;
    }
}