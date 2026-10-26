class Solution {
    List<List<Integer>> res;
    List<Integer> subset;
    public void backtrack(int[] nums , int i) {
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums,i+1);
        subset.remove(subset.size()-1);
        while(i+1 < nums.length && nums[i]==nums[i+1]) {
            i++;
        }
        backtrack(nums,i+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }
}
