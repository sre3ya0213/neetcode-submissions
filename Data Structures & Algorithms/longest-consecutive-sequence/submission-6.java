class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int num : set) {
            
            if(set.contains(num-1)) {
                continue;
            }
            int c=1;
            while(set.contains(num+c)) {
                c++;
            }
            maxLen = Math.max(c,maxLen);
        }

        return maxLen;
        
    }
}
