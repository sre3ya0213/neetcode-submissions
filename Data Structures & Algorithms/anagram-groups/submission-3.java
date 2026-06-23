class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<List<Integer>,List<String>> check = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            List<Integer> arr = new ArrayList<>(Collections.nCopies(26,0));
            for(int j=0;j<strs[i].length();j++)
            {
                arr.set(strs[i].charAt(j)-'a',arr.get(strs[i].charAt(j)-'a') + 1);
            }
            List<String> value = check.getOrDefault(arr, new ArrayList<>());
            value.add(strs[i]);
            check.put(arr,value);   
        }
        for(List<String> val : check.values())
        {
            result.add(val);
        }
        return result;
    }
}
