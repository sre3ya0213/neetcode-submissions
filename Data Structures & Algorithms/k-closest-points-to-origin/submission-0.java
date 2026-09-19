class Solution {

    public int EcDistance(int[] p) {
        return (p[0]*p[0]) + (p[1]*p[1]);
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(EcDistance(b),EcDistance(a)));
        int[][] res = new int[k][2];
        for(int i=0;i<points.length;i++) {
            maxHeap.offer(points[i]);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int j=0;
        for(int[] val : maxHeap) {
            res[j] = val;
            j++;
        }
        return res;
    }
}
