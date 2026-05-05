class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> store = new HashMap<>();
        int i;
        for(i=0;i<nums.length;i++) {
            if(store.containsKey(target-nums[i])) {
                // res[0] =  store.get(target-nums[i]);
                // res[1] = i;
                // return res;
                break;
            }
            store.put(nums[i],i);
        }
        return new int[]{store.get(target-nums[i]),i};
    }

}