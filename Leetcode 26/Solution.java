class Solution {
    public int removeDuplicates(int[] nums) {
        int non_dups = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[non_dups]){
                non_dups++;
                nums[non_dups] = nums[i];
            }
        }
        return non_dups+1;
    }
}