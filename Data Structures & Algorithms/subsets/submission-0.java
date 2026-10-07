class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public void backtrack(int[] nums , int i) {
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums,i+1);
        subset.remove(subset.size()-1);
        backtrack(nums,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }
}
