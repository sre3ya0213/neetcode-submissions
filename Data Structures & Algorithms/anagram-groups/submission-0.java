class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            List<Integer> count = new ArrayList<>(Collections.nCopies(26,0));
            for(int j=0;j<strs[i].length();j++)
            {
                count.set(strs[i].charAt(j)-'a',count.get(strs[i].charAt(j)-'a')+1);
            }
            List<String> val = new ArrayList<>();
            if(map.containsKey(count))
            {
                val.addAll(map.get(count));
            }
            val.add(strs[i]);
            map.put(count,val);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> vals : map.values())
        {
            res.add(vals);
        }
        return res;
    }
}
