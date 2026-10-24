class Solution {

    List<List<Integer>> res;
    List<Integer> permutation;
    public void backtrack(int[] nums , boolean[] used) {
        if(permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }
        for(int i=0;i<used.length;i++) {
            if(!used[i]) {
                permutation.add(nums[i]);
                used[i] = true;
                backtrack(nums,used);
                permutation.remove(permutation.size()-1);
                used[i] = false;
            }
        }
    }
 
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used);
        return res;
    }
}
