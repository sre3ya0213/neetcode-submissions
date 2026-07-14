class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int l=0;
        int maxLen = 0;
        for(int r=0;r<s.length();r++)
        {
            if(mp.containsKey(s.charAt(r))) {
                l = Math.max(mp.get(s.charAt(r)) + 1,l);
            }
            mp.put(s.charAt(r),r);
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}
