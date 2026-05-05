class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] temp = Arrays.copyOf(nums, nums.length);
        for(int num:nums)
        {
            prod = prod*num;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != 0)
            {
                nums[i] = prod/nums[i];
            }
            else
            {
                nums[i] = prodIgnoreIndex(temp,i);
            }
        }
        return nums;
    }

    public int prodIgnoreIndex(int[] arr , int k)
    {
        int prod = 1;
        for(int i=0;i<arr.length;i++)
        {
            if(i != k)
            {
                prod = prod*arr[i];
            }
        }
        return prod;
    }

}  
