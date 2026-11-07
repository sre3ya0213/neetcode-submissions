class Solution {
    List<List<String>> res;
    public boolean isPalindrome(String s) {
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
    public void backtrack(String s,List<String> palindromes,int j) {
        if(j == s.length()) {
            res.add(new ArrayList<>(palindromes));
            return;
        }
        for(int i=j;i<s.length();i++) {
            if(isPalindrome(s.substring(j,i+1))) {
                palindromes.add(s.substring(j,i+1));
                backtrack(s,palindromes,i+1);
                palindromes.remove(palindromes.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s,new ArrayList<>(),0);
        return res;
    }
}
