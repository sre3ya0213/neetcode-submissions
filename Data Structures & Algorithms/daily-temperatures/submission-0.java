class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int k = st.pop();
                res[k] = i-k;
            }
            st.push(i);
        }   
        return res;
    }
}
