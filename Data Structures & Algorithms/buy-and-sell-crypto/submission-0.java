class Solution {
    public int maxProfit(int[] prices) {
        int maxSoFar = 0;
        int buy = 0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]-prices[buy] < 0)
            {
                buy=i;
            }
            maxSoFar = Math.max(maxSoFar , prices[i]-prices[buy]);
        }

        return maxSoFar;
        
    }
}
