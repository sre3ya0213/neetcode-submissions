class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for(int i=0,j=n-1;i<n && j>=0;i++,j--) {
            if(height[i] > leftMax) {
                leftMax = height[i];
            }
            if(height[j] > rightMax) {
                rightMax = height[j];
            }
            prefix[i] = leftMax;
            suffix[j] = rightMax;
        }

        int area = 0;

        for(int i=0;i<n;i++) {
            area+= Math.min(prefix[i],suffix[i])-height[i];
        }

        return area;

        
    }
}
