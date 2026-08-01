class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int k=0; // upper bound
        while(l <= r) {
            int mid = l + ((r-l)/2);
            if(nums[mid] > target) {
                r = mid-1;
            }
            else {
                k = mid;
                l = mid+1;
            }
        }
       return  nums[k] == target ? k : -1;
    }
}
