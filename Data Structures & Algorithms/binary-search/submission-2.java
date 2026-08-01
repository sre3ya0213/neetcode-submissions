class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1; // lower bound
        int k = 0;
        while(l <= r) {
            int mid = l + ((r-l)/2);
            if(nums[mid] >= target) {
                k = mid;
                r = mid-1;
            }
            else {
                l = mid+1;  
            }
        }
       return  nums[k] == target ? k : -1;
    }
}
