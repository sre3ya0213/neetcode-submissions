class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int l=0;
        int[] res = new int[nums.length-k+1];
        for(int r=0;r<nums.length;r++) {
            maxHeap.offer(new int[]{nums[r],r});
            if(r >= k-1) {
                while(!maxHeap.isEmpty() && maxHeap.peek()[1] < r-k+1) {
                    maxHeap.poll();
                }
                res[l] = maxHeap.peek()[0];
                l++;
            }
        }
        return res;
    }
}
