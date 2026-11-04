class Solution {

    List<List<Integer>> res;
    List<Integer> subset;
    Long sum = 0L;
    public void backtrack(int[] candidates,int target,int i) {
        if(sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int j=i;j<candidates.length;j++) {
            if(sum + candidates[j] > target) {
                break;
            }
            subset.add(candidates[j]);
            sum+=candidates[j];
            backtrack(candidates,target,j+1);
            subset.remove(subset.size()-1);
            sum-=candidates[j];
            while(j < candidates.length-1 && candidates[j] == candidates[j+1]) {
               j++;
            }
        }  
    }  
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        subset = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return res;
    }
}
