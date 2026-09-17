class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        for(int wt : stones) {
            maxHeap.offer(wt);
        }
        while(maxHeap.size() > 1) {
            int w1 = maxHeap.poll();
            int w2 = maxHeap.poll();
            maxHeap.offer(w1-w2);
        }
        return maxHeap.peek();
         
    }
}
