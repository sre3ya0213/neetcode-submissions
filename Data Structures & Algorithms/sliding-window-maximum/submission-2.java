class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque();
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        for(int r=0;r<nums.length;r++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.removeLast();
            }
            while(!dq.isEmpty() && dq.peekFirst() < l) {
                dq.removeFirst();   
            }  
            dq.addLast(r);  
            if(r >= k-1) {
                
                res[l] = nums[dq.peekFirst()]; 
                l++; 
            }            
        }
        return res;
    }
}
