class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> store = new HashSet<>();
        int res = 0;
        for(int num : nums)
        {
            store.add(num);
        }
        
        for(int num : nums)
        {
            
            if(!store.contains(num-1))
            {
                int next = num;
                int count=0;
                while(store.contains(next))
                {
                    count++;
                    next++;
                }
                res = Math.max(res,count);
            }
            
        }

        return res;
    }
}
