class Solution {
    public int characterReplacement(String s, int k) {

        int maxLen = 0;
        Map<Character,Integer> freq = new HashMap<>();
        int mostFreq = 0;
        for(int l=0,r=0;r<s.length();r++)
        {
            freq.put(s.charAt(r),freq.getOrDefault(s.charAt(r),0)+1);
            mostFreq = Math.max(mostFreq,freq.get(s.charAt(r)));
            while(r-l+1-mostFreq > k)
            {
                freq.put(s.charAt(l),freq.get(s.charAt(l))-1);
                l++;
            }
            maxLen = Math.max(maxLen , r-l+1);
            
        }
        return maxLen;
        
    }
}
