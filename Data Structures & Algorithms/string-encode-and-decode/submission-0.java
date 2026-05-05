class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(int i=0;i<strs.size();i++)
        {
            encoded = encoded + strs.get(i).length() + "|" + strs.get(i);
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        String count = "";
        for(int i=0;i<str.length();)
        {
            if(str.charAt(i) != '|')
            {
                count = count + (str.charAt(i));
                i++;
            }
            else
            {
                int len = Integer.parseInt(count);
                decoded.add(str.substring(i+1,len+i+1));
                count="";
                i = i+len+1;
            }
        }
        return decoded;
    }
}
