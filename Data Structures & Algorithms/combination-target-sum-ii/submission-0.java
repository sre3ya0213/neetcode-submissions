class Solution {

    List<List<Integer>> res;
    List<Integer> subset;
    int sum = 0;
    public void backtrack(int[] nums , int j , int target) {
        if(sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(sum > target || j == nums.length) { 
            return;
        }
    
        sum+=nums[j];
        subset.add(nums[j]);
        backtrack(nums,j+1,target);
        sum-=nums[j];
        subset.remove(subset.size()-1);
        int k = j+1;
        while( k < nums.length && nums[j] == nums[k]) {
            k++;
        }
        backtrack(nums,k,target);
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<>();
        subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,target);
        return res;
        
    }
}

