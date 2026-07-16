class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i=0;i<s2.length()-s1.length()+1;i++)
        {
            if(s1.indexOf(s2.charAt(i)) == -1) {
                continue;
            }
            String permutation = s2.substring(i,i+s1.length());
            Map<Character,Integer> mp = new HashMap<>();
            for(int c=0;c<s1.length();c++)
            {
                mp.put(s1.charAt(c),mp.getOrDefault(s1.charAt(c),0)+1);
                mp.put(permutation.charAt(c),mp.getOrDefault(permutation.charAt(c),0)-1);
            }
            int flag = 0;
            for(Integer val : mp.values())
            {
                if(val != 0 )
                {
                    flag = 1;
                }
            }
            if(flag == 0)
            {
                return true;
            }
        }
        return false;
    }
}
