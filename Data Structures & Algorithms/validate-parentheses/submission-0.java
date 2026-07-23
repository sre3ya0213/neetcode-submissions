class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        boolean flag = true;
        for(int i=0;i<s.length();i++) {
            if(!Arrays.asList(')','}',']').contains(s.charAt(i)))
            {
                st.push(s.charAt(i));
            }
            else {
                if(st.isEmpty())
                {
                    return false;
                }
                switch (s.charAt(i)) {
                    case ')':
                        flag = st.pop() == '(';
                        break;
                    case '}':
                        flag = st.pop() == '{';
                        break;
                    case ']':
                        flag = st.pop() == '[';
                        break;
                    default :
                        flag = false; 
                        break;   
                }
                if(!flag)
                {
                    return false;
                }
            }
        }

        return st.isEmpty();
        
    }
}
