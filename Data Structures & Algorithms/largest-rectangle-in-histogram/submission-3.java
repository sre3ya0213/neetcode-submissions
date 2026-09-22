class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int area = 0;
        int n = heights.length;
        for(int i=0;i<=n;i++) {
            while(!st.isEmpty() && (i == n || heights[st.peek()] > heights[i])) {
                int right = i-1;
                int h = st.pop();
                int left = !st.isEmpty() ? st.peek()+1 : 0;
                area = Math.max(area,(right-left+1)*heights[h]);  
            }
            st.push(i);
        }
        return area;
    }
}
