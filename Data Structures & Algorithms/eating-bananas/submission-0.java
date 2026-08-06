class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Arrays.stream(piles).max().getAsInt();
        int l=1;
        int r=max;
        int k=max;
        while(l<=r) {
            int mid = l + ((r-l)/2);
            int time = 0;
            for(int p : piles) {
                time = time + ((p+mid-1)/mid);
            }
            if(time <= h)
            {
                r = mid-1;
                k = mid;
            }
            else {
                l = mid+1;
            }
        }
       
        return k;
        
    }
}
