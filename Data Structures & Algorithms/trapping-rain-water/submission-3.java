class Solution {
    public int trap(int[] height) {
        int[] preMax = new int[height.length];
        int[] sufMax = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        for(int i=0,j=height.length-1;i<height.length || j>=0;i++,j--) {
            leftMax = Math.max(leftMax,height[i]);
            rightMax = Math.max(rightMax,height[j]);
            preMax[i] = leftMax;
            sufMax[j] = rightMax;
        }
        for(int i=0;i<height.length;i++)
        {
            res = res + Math.min(preMax[i],sufMax[i]) - height[i];
        }
        return res;

    }
}
