class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[l] <= nums[mid]) {
                if(nums[l] <= target && nums[mid] >= target) {
                    return binarySearch(nums,l,mid,target);
                }
                l = mid+1;
            }
            else {
                if(nums[mid] <= target && nums[r] >= target) {
                    return binarySearch(nums,mid,r,target);
                }
                r = mid-1;
            }
            
        }

        return -1;    
    }

    public int binarySearch(int[] arr,int l,int r,int target) {
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] > target) {
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return -1;
    }
}
