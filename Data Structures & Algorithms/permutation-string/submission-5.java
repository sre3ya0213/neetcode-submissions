class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int c=0; c<s1.length();c++) {
            arr1[s1.charAt(c)-'a']++;
        }
        int l=0;
        for(int r=0;r<s2.length();r++) {
            
            arr2[s2.charAt(r)-'a']++;
            if(r-l+1 == s1.length()) {
                if(Arrays.equals(arr1,arr2)) {
                    return true;
                }
                arr2[s2.charAt(l)-'a']--;
                l++;
            }
            
        }
        return false;

    }
}
