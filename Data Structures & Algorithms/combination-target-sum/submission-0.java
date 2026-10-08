class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    int sum = 0;
    public void backtrack(int[] nums , int i , int target) {
        if(sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(sum > target || i == nums.length) {
            return;
        }
        sum+=nums[i];
        subset.add(nums[i]);
        backtrack(nums,i,target);
        sum-=nums[i];
        subset.remove(subset.size()-1);
        backtrack(nums,i+1,target);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        backtrack(nums,0,target);
        return res;
        
    }
}
