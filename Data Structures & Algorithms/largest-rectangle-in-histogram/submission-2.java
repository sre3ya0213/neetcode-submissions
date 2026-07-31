class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<=heights.length;i++) {
            while(!stack.isEmpty() && (i==heights.length || heights[stack.peek()] > heights[i])) {
                int idx = stack.pop();
                int left = !stack.isEmpty() ? stack.peek()+1 : 0;
                area = Math.max(area,heights[idx]*((i-1)-left+1));
            }
            stack.push(i);
        }
      
        return area;
        
    }
}
