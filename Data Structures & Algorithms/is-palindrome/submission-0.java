class Solution {
    public boolean isPalindrome(String s) {
        
        String formatted = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0,j=formatted.length()-1;
        while(i<j)
        {
            if(formatted.charAt(i) != formatted.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}
