class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pArr = new int[nums.length];
        int[] sArr = new int[nums.length];
        int[] res = new int[nums.length];
        pArr[0] = 1;
        sArr[nums.length-1] = 1;
        for(int i=1,j=nums.length-2;i<nums.length || j>0;i++,j--)
        {
            pArr[i] = pArr[i-1]*nums[i-1];
            sArr[j] = sArr[j+1]*nums[j+1];
        }
        for(int i=0;i<nums.length;i++)
        {
            res[i] = pArr[i]*sArr[i];
        }
        return res;
    }
}  
