class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> count = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            int[] temp = new int[26];
            for(int j=0;j<strs[i].length();j++)
            {
                temp[strs[i].charAt(j)-'a']++;   
            }
            List<String> val = count.getOrDefault(Arrays.toString(temp),new ArrayList<>());
            val.add(strs[i]);
            count.put(Arrays.toString(temp),val);
        }
        for(List<String> val : count.values())
        {
            result.add(val);
        }
        return result;
    }
}
