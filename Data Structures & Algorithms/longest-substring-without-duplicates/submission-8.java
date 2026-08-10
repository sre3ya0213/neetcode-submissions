class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        int i=0,j;
        for(j=0;j<s.length();j++) {
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i) {
                i = map.get(s.charAt(j)) + 1;          
            }
            map.put(s.charAt(j),j);
            res = Math.max(res,j-i+1); 
        }
        return res;     
    }
}
