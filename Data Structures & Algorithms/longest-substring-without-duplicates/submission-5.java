class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character,Integer> store = new HashMap<>();
       int k=0;
       int maxLen = 0;
       int curLen = 0;
       for(int i=0;i < s.length();i++)
       {
            while(store.containsKey(s.charAt(i)) && store.get(s.charAt(i)) > 0 && k<s.length()) {
                store.put(s.charAt(k),0);
                k++;
                curLen--;
            }
             store.put(s.charAt(i),1);
             curLen++;
             maxLen = Math.max(maxLen,curLen); 
       }
       return maxLen;
         
    }
}
