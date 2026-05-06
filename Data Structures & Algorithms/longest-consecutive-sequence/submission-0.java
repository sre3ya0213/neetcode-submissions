class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        // brute force  O(n^2)   hashSet lookup is O(1)
        int res = 0;
        Set<Integer> store = new HashSet<>();
        for(int num : nums) {
            store.add(num);
        }
        
        for(int num : nums) {
            int count = 0;
            int k=num;
            while(store.contains(k))
            {
                count++;
                k++;
            }
            
            res = Math.max(res,count);
            
        }
        
        return res;
        
    }
}
