class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->(b-a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        if(num > maxHeap.peek()) {
            minHeap.offer(num);
            if(maxHeap.size() != minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        else {
            maxHeap.offer(num);
            if(maxHeap.size() != minHeap.size()+1){
                minHeap.offer(maxHeap.poll());
            }
        }
        
    }
    
    public double findMedian() {

        if((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek())/ 2.0;
        }

        return maxHeap.peek();
        
    }
}
