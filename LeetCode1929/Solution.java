class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int j = 0;
        for(int i = 0; i < ans.length; i++){
            ans[i] = nums[j];
            j++;
            if(j == nums.length)
                j = 0;
        }
        return ans;
    }
}