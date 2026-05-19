class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int i=0,j=height.length-1;
        int curLmax = height[i];
        int curRmax = height[j];
        while(i<height.length && j>=0)
        {
            if(curLmax < height[i])
            {
                curLmax = height[i];
            }
            if(curRmax < height[j])
            {
                curRmax = height[j];
            }
            maxLeft[i] = curLmax;
            maxRight[j] = curRmax;
            i++;
            j--;
        }
        int trapArea = 0;
        for(int k=0;k<height.length;k++)
        {
            trapArea = trapArea + Math.min(maxLeft[k],maxRight[k]) - height[k];
        }
        return trapArea;
    }
}
