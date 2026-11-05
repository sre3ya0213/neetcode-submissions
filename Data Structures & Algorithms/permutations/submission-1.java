class Solution {
    List<List<Integer>> res;

    public void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void backtrack(int[] nums,int i) {
        if(i == nums.length) {
            List<Integer> pm = new ArrayList<>();
            for(int num:nums) {
                pm.add(num);
            }
            res.add(new ArrayList<>(pm));
            return;
        }
        for(int j=i;j<nums.length;j++) {
            swap(nums,i,j);
            backtrack(nums,i+1);
            swap(nums,i,j);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums,0);
        return res;
        
    }
}
