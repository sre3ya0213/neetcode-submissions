class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> vals = new HashSet<>();
        for(int num : nums)
        {
            if(!vals.add(num))
            {
                return true;
            }
        }
        return false;
    }
}