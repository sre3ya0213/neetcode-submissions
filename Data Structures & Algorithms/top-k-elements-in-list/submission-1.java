class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>> bucketList = new ArrayList<>();
        for(int i=0;i<nums.length+1;i++)
        {
            bucketList.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet())
        {
            List<Integer> values = bucketList.get(m.getValue());
            values.add(m.getKey());
            bucketList.set(m.getValue(),values);
        }
        int count = 0;
        for(int i=bucketList.size()-1;i>0 && count < k;i--)
        {
            for(int num : bucketList.get(i))
            {
                res[count] = num;
                count++;
                if(count == k)
                {
                    return res;
                }
            }
               
            //    for(int j=0;j<bucketList.get(i).size() && count < k;j++)
            //    {
            //       res[count] = bucketList.get(i).get(j);
            //       count++;
            //    } 
        }

        return res;
    }
}
