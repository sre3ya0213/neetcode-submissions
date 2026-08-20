class Solution {
    public int findDuplicate(int[] nums) {

        int val = 0;
        while(nums[val] >= 0) {
            int temp = nums[val];
            nums[val] *= -1;
            val = temp;
        }

        return val;
        
    }
}
