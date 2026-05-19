class Solution {
    public int findMax(int[] arr , int i , int j)
    {
        int max = arr[i];
        for(int k = i;k<=j;k++)
        {
            if(max < arr[k])
            {
                max = arr[k];
            }
        }
        return max;
    }
    public int trap(int[] height) {
        int area = 0;
        for(int i=0;i<height.length;i++) {
            area = area + Math.min(findMax(height,0,i),findMax(height,i,height.length-1)) - height[i];
        }
        return area;
   
    }
}
