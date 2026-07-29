class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stackR = new Stack<>();
        Stack<Integer> stackL = new Stack<>();
        int res = 0;
        for(int j=heights.length-1;j>=0;j--) {
            while(!stackL.isEmpty() && heights[stackL.peek()] > heights[j]) {
                left[stackL.peek()] = j+1;
                stackL.pop();
            }
            stackL.push(j);    
        }
        for(int i=0;i<heights.length;i++) {
            while( !stackR.isEmpty() && heights[stackR.peek()] > heights[i]) {
                right[stackR.peek()] = i-1;
                stackR.pop();
            }
            stackR.push(i);   
        }
        for (int i = stackR.size() - 1; i >= 0; i--) {
             right[stackR.get(i)] = heights.length-1;
        }
        for(int i=0;i<heights.length;i++) {
            res = Math.max(heights[i]*(right[i]-left[i] + 1) , res);
        }
        return res;
        
    }
}
