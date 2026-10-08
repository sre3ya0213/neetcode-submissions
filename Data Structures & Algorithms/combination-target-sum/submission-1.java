class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    int sum = 0;
    public void backtrack(int[] nums , int i , int target) {
        if(sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int j=i;j<nums.length;j++) {
            if(sum + nums[j] > target) {
                return;
            } 
            sum+=nums[j];
            subset.add(nums[j]);
            backtrack(nums,j,target);
            sum-=nums[j];
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums,0,target);
        return res;
        
    }
}

