class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> check = new HashMap<>();
        if(s.length() != t.length())
        {
            return false;
        }
        for(int i=0;i<s.length();i++)
        {
            check.put(s.charAt(i),check.getOrDefault(s.charAt(i),0)+1);
            check.put(t.charAt(i),check.getOrDefault(t.charAt(i),0)-1);
        }
        for( Integer val : check.values())
        {
            if(val != 0)
            {
                return false;
            }
        }
        return true;
    }
}
