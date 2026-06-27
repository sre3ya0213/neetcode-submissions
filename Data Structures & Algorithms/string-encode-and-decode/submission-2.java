class Solution {

    public String encode(List<String> strs) {
        String decoded = "";
        for(int i=0;i<strs.size();i++)
        {
             decoded = decoded + strs.get(i).length()+ "#" + strs.get(i);
        }
        return decoded;
    }

    public List<String> decode(String str) {
        List<String> encodedRes = new ArrayList<>();
        for(int i=0;i<str.length();)
        {
            int j=i;
            while(str.charAt(j) != '#')
            {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            encodedRes.add(str.substring(j+1,length+j+1));
            i=j+length+1;
        }
        return encodedRes;

    }
}
