class Solution {
    List<List<Integer>> res;
    List<Integer> subset;
    public void backtrack(int[] nums , int i) {
        res.add(new ArrayList<>(subset));
        for(int j=i;j<nums.length;j++) {
            subset.add(nums[j]);
            backtrack(nums,j+1);
            subset.remove(subset.size()-1);
            while(j < nums.length-1 && nums[j] == nums[j+1]) {
                j++;
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
        
    }
}
