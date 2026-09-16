class Solution {

    public int binarySearch(int[] nums, int k,int l,int r) {
        if(l > r) {
            return -1;
        }
        int mid = l + (r-l)/2;
        if(nums[mid] == k) {
            return mid;
        }
        else if(nums[mid] < k) {
            return binarySearch(nums,k,mid+1,r);
        }
        return binarySearch(nums,k,l,mid-1);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
}
