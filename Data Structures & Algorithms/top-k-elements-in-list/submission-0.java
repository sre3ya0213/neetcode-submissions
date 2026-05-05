class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            String key = String.valueOf(nums[i]);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        Map<String,Integer> sortedMap = map.entrySet().stream()
              .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
              .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
        int j=0;
        for(Map.Entry<String,Integer> m : sortedMap.entrySet())
        {
           if(j >= k)
           {
              break;
           }
           res[j] = Integer.valueOf(m.getKey());
           j++;
        }
        return res;
    }
}
