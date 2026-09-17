class KthLargest {
    
    PriorityQueue<Integer> pq;
    int n;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        n=k;
        for(int i=0;i<nums.length;i++) {
            if(pq.size() == k) {
                if(pq.peek() <= nums[i]) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
            else {
                pq.offer(nums[i]);
            } 
        }
    }
    
    public int add(int val) {
        if(pq.size() < n) {
            pq.offer(val);
        }
        else if(val >= pq.peek()) {
           pq.poll();
           pq.offer(val);
        }
       return pq.peek();   
    }
}
