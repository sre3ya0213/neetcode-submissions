class Solution {
    List<List<Integer>> res;
    List<Integer> subset;
    public void backtrack(int[] nums , int target , int i) {
        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(i == nums.length || target < 0) {
            return;
        }
        subset.add(nums[i]);
        backtrack(nums,target-nums[i],i);
        subset.remove(subset.size()-1);
        backtrack(nums,target,i+1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        subset = new ArrayList<>();
        backtrack(nums,target,0);
        return res;
    }
}
