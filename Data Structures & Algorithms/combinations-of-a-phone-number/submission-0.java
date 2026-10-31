class Solution {

   List<String> res;
   StringBuilder sb; 
    public void backtrack(String digits,Map<Character,String> letters,int i) {
        if(i == digits.length()) {
            StringBuilder comb = new StringBuilder(sb);
            res.add(sb.toString());
            return;
        }
        for(int j=0;j<letters.get(digits.charAt(i)).length();j++) {
            sb.append(letters.get(digits.charAt(i)).charAt(j));
            backtrack(digits,letters,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }   
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        if(digits.isEmpty()) {
            return res;
        }
        List<String> list = new ArrayList<>(List.of("#","#","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));

        Map<Character,String> letters = new HashMap<>();
        for(int i=0;i<digits.length();i++) {
            letters.put(digits.charAt(i),list.get(Integer.parseInt(String.valueOf(digits.charAt(i)))));
        }
        backtrack(digits,letters,0);
        return res;
       
    }
}
