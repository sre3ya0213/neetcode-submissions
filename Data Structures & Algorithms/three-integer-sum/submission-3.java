class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++)
        {
            if (nums[i] > 0)
                break;
            int l=i+1 ,r=nums.length-1;
            if(i>0 && nums[i-1] == nums[i]) {
                continue;
            }
            while(l<r)
            {
                if(nums[l]+nums[r] == (-1)*nums[i])
                {
                    res.add(new ArrayList<>(List.of(nums[l],nums[r],nums[i])));
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1])
                    {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) r--;
                        
                }
                if(nums[l]+nums[r] > (-1)*nums[i])
                {
                    r--;
                }
                if(nums[l]+nums[r] < (-1)*nums[i])
                {
                    l++;
                }
            }
        }
        return res;

    }
}
