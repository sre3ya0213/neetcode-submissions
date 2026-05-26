class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> temp = new HashSet<>();
        int l=0,r=0;
        while(r<s.length()) {
            if(!temp.contains(s.charAt(r))) {
                temp.add(s.charAt(r));
                maxLen = Math.max(maxLen , r-l+1);
                r++;
            }
            else {
                temp.remove(s.charAt(l));
                l++;
            }
        }
        return maxLen;
    }
}
