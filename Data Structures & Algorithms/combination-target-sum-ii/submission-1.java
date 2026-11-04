class Solution {

    List<List<Integer>> res;
    List<Integer> subset;
    public void backtrack(int[] candidates,int target,int i) {
        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(i == candidates.length || target < 0) {
            return;
        }
        subset.add(candidates[i]);
        backtrack(candidates,target-candidates[i],i+1);
        subset.remove(subset.size()-1);
        while(i < candidates.length-1 && candidates[i] == candidates[i+1]) {
            i++;
        }
        backtrack(candidates,target,i+1);
    }  
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        subset = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return res;
    }
}
