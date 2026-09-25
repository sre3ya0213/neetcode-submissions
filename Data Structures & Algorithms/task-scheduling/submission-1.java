class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        for(char c : tasks) {
            count[c-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));

        for(int val : count) {
            if(val > 0) {
                maxHeap.offer(val);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!q.isEmpty() || !maxHeap.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int ct = maxHeap.poll()-1;
                if(ct > 0) {
                    q.offer(new int[]{ct,time+n});
                }
            }
            if(!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
