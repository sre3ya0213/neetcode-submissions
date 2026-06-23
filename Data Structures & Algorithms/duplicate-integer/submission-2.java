class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> check = new HashSet<>();
        for(int num : nums)
        {
            if(!check.add(num)) {
                return true;
            }
        }
        return false;
    }
}