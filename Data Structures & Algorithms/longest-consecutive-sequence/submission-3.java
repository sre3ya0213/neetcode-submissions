class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int count = 0;
        int next = nums[0];
        int i=0;
        while(i < nums.length)
        {
            if(next != nums[i])
            {
                count = 0;
                next = nums[i];
            }
            while(i < nums.length && next == nums[i])
            {
                i++;
            }
            count++;
            next++;
            res = Math.max(res,count);
        }

        return res;
    }
}
