class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
        {
            return s.length();
        }
        int maxLen = 0;
        for(int i=0;i<s.length();i++)
        {
            Set<Character> temp = new HashSet<>();
            for(int j=i;j<s.length();j++)
            {
                if(temp.contains(s.charAt(j))) {
                    break;
                }
                temp.add(s.charAt(j));
            }
            maxLen = Math.max(temp.size(),maxLen);
        }

        return maxLen;
        
    }
}
