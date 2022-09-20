class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr = 0;
        int total = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                nums[i] = 102;
                total--;
                if(nums[ptr] != 102)
                    ptr = i;
            }else if(nums[ptr] == 102){
                int hold = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = hold;
                ptr++;    
            }
        }
        
        return total;
    }
}