class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
           return findMedianSortedArrays(nums2,nums1); 
        }
        int l=0;
        int r=nums1.length;
        int m = nums1.length;
        int n = nums2.length;
        int half = (m+n+1)/2;
        
        while(l <= r) {
            int p1 = l + (r-l)/2;
            int p2 = half-p1;
            int left1 = p1 < 1 ? Integer.MIN_VALUE : nums1[p1-1];
            int right1 = p1 == m ? Integer.MAX_VALUE : nums1[p1];
            int left2 = p2 < 1 ? Integer.MIN_VALUE : nums2[p2-1];
            int right2 = p2 == n ? Integer.MAX_VALUE : nums2[p2];
            if( left1 <= right2 && right1 >= left2) {
                double leftMax = Math.max(left1,left2);
                return (m+n) % 2 == 0 ? (leftMax + Math.min(right1,right2)) / 2 : leftMax;
            }
            else if(left1 > right2) {
                r=p1-1;
            }
            else if(left2 > right1){
                l=p1+1;
            }

        }
        return -1;  
    }
}
