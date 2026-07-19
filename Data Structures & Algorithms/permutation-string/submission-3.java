class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) 
        {
            return false;
        }
        int[] count = new int[26];
        for(int i=0;i < s1.length();i++)
        {
            count[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<=s2.length()-s1.length();i++)
        {
            int[] subCount = new int[26];
            for(int j=i;j<i+s1.length();j++)
            {
                subCount[s2.charAt(j)-'a']++;
            }
            int flag = 0;
            for(int k=0;k<26;k++)
            {
                if(count[k] != subCount[k])
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
