class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }
        Map<Integer,Integer> store = new HashMap<>();
        int res=0;
        for(int num : nums)
        {
            if(!store.containsKey(num))           // update number and its boundaries
            {
                Integer left = store.getOrDefault(num-1,0);
                Integer right = store.getOrDefault(num+1,0);
                Integer count = left+right+1;
                store.put(num,count);
                store.put(num-left,count);
                store.put(num+right,count);
                res = Math.max(res,count);
            }
        }

        return res;
    }
}
