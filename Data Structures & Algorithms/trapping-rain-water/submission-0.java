class Solution {
    public int trap(int[] height) {
        int trapArea = 0;
        for(int i=0;i<height.length;i++)
        {
            int maxL = 0;
            int maxR = 0;
            int l=0,r=height.length-1;
            while(l<i || r>i)
            {
                maxL = Math.max(height[l],maxL);
                maxR = Math.max(height[r],maxR);
                if(l<i)
                {
                    l++;
                }
                if(r>i) {
                    r--;
                } 
            }
            if(Math.min(maxL,maxR) > height[i])
            {
                trapArea = trapArea + Math.min(maxL,maxR)-height[i];
            }
        }
        
        return trapArea;


    }
}
