class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> check = new HashMap<>();
        for(int i=0; i<nums.length ; i++) {
            if(check.containsKey(target-nums[i]))
            {
                return new int[]{check.get(target-nums[i]),i};
            }
            check.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
