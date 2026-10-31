class Solution {
    List<List<String>> res;
    List<String> substrings;
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) {
            return false;
        }
        int i=0,j=s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void backtrack(String s,int j,int i) {
        if(j == s.length()) {
            res.add(new ArrayList<>(substrings));
            return;
        }
         if(i == s.length()) {
            return;
        }
        if(isPalindrome(s.substring(j,i+1))) {
            substrings.add(s.substring(j,i+1));
            backtrack(s,i+1,i+1);
            substrings.remove(substrings.size()-1);
        }
        backtrack(s,j,i+1);
    }
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        substrings = new ArrayList<>();
        backtrack(s,0,0);
        return res;
        
    }
}
