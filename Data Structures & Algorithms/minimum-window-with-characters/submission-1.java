class Solution {
    public String minWindow(String s, String t) {
        int[] res  =  {-1,-1};
        int len = Integer.MAX_VALUE;
        if(t.isEmpty() || t.length() > s.length())
        {
            return "";
        }
        Map<Character,Integer> tCount = new HashMap<>();
        Map<Character,Integer> sCount = new HashMap<>();
        
        for(int i=0;i<t.length();i++)
        {
            tCount.put(t.charAt(i),tCount.getOrDefault(t.charAt(i),0)+1);
        }
        int need = tCount.size();
        int l=0;
        int have = 0;
        for(int r=0;r<s.length();r++) {
            sCount.put(s.charAt(r),sCount.getOrDefault(s.charAt(r),0)+1);
            if(tCount.containsKey(s.charAt(r)) && sCount.get(s.charAt(r)) == tCount.get(s.charAt(r))) {
                have++;
            }
            while(have == need)
            {
                if(r-l+1 < len) {
                    len = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                sCount.put(s.charAt(l),sCount.get(s.charAt(l))-1);
                if(tCount.containsKey(s.charAt(l)) && sCount.get(s.charAt(l)) < tCount.get(s.charAt(l))) {
                    have--;
                }
                l++;
            }
               
        }
        
        return len ==Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}
