class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> mp = new HashMap<>();
        int[] res = new int[k];

        for(int i=0;i<nums.length;i++) {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0;i<=nums.length;i++) {
            ls.add(i,new ArrayList<>());
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()) { 
            ls.get(entry.getValue()).add(entry.getKey());
        }

        int count = 0;
        int j=ls.size()-1;
        while(j>=0 && count<k) {
            for(int i=0;i<ls.get(j).size() && count<k;i++) {
                res[count++] = ls.get(j).get(i);
            }
           j--;
        }

        return res;


        
        
    }
}
